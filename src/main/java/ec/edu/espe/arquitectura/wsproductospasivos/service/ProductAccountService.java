package ec.edu.espe.arquitectura.wsproductospasivos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountRQ;
import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountRS;
import ec.edu.espe.arquitectura.wsproductospasivos.model.productAccount;
import ec.edu.espe.arquitectura.wsproductospasivos.repository.ProductAccountRepository;


@Service
public class ProductAccountService {
    private final ProductAccountRepository productAccountRepository;

    
    
    public ProductAccountService(ProductAccountRepository productAccountRepository) {
        this.productAccountRepository = productAccountRepository;
    }

    public List<ProductAccountRS> getAllProductService(){
        List<productAccount> Products = this.productAccountRepository.findAll();
        List<ProductAccountRS> ProductList = new ArrayList<>();
        for(productAccount Product : Products){
            ProductList.add(this.responseProductAccount(Product));
        }
        return ProductList;
    }

    public ProductAccountRS obtainLoanProductByUniqueKey(String uniqueKey) {
        try {
            productAccount product = this.productAccountRepository.findByUniqueKey(uniqueKey);
            ProductAccountRS response = responseProductAccount(product);
            return response;
        } catch (RuntimeException rte) {
            throw new RuntimeException("Error al obtener loan product", rte);
        }
    }

    public ProductAccountRS obtainProductByUniqueKeyAndState(String uniqueKey,String state) {
        try {
            productAccount product = this.productAccountRepository.findByUniqueKeyAndState(uniqueKey,state);
            ProductAccountRS response = responseProductAccount(product);
            return response;
        } catch (RuntimeException rte) {
            throw new RuntimeException("Error al obtener loan product", rte);
        }
    }

    


    public productAccount transformProductAccountRQ(ProductAccountRQ rq){
        productAccount ProductAccount = productAccount
                .builder()
                .name(rq.getName())
                .temporalityAccountStatement(rq.getTemporalityAccountStatement())
                .maxOverDraft(rq.getMaxOverDraft())
                .customerType(rq.getCustomerType())
                .minOpeningBalance(rq.getMinOpeningBalance())
                .minInterest(rq.getMinInterest())
                .maxInterest(rq.getMaxInterest())
                .state(rq.getState())
                .creationDate(rq.getCreationDate())
                .activationDate(rq.getActivationDate())
                .lastModifiedDate(rq.getLastModifiedDate())
                .closedDate(rq.getClosedDate())
                .build();
        return ProductAccount;
    }

    public ProductAccountRS responseProductAccount(productAccount rq){
        ProductAccountRS productAccountRS = ProductAccountRS
                .builder()
                .name(rq.getName())
                .temporalityAccountStatement(rq.getTemporalityAccountStatement())
                .maxOverDraft(rq.getMaxOverDraft())
                .customerType(rq.getCustomerType())
                .minOpeningBalance(rq.getMinOpeningBalance())
                .minInterest(rq.getMinInterest())
                .maxInterest(rq.getMaxInterest())
                .state(rq.getState())
                .creationDate(rq.getCreationDate())
                .activationDate(rq.getActivationDate())
                .lastModifiedDate(rq.getLastModifiedDate())
                .closedDate(rq.getClosedDate())
                .build();
        return productAccountRS;
    }


    public productAccount obtainByUniqueKey(String uniqueKey){
        return this.productAccountRepository.findByUniqueKey(uniqueKey);
    }

    

    

    
}
