package ec.edu.espe.arquitectura.wsproductospasivos.service;

import java.util.ArrayList;
import java.util.List;

import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountTypeRS;
import ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccount;
import ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccountType;
import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountRQ;
import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountRS;
import ec.edu.espe.arquitectura.wsproductospasivos.repository.ProductAccountRepository;


@Service
public class ProductAccountService {
    private final ProductAccountRepository productAccountRepository;
    
    public ProductAccountService(ProductAccountRepository productAccountRepository) {
        this.productAccountRepository = productAccountRepository;
    }

    public List<ProductAccountRS> getAllProductService(){
        List<ProductAccount> products = this.productAccountRepository.findAll();
        List<ProductAccountRS> productList = new ArrayList<>();
        for(ProductAccount product : products){
            productList.add(this.responseProductAccount(product));
        }
        return productList;
    }

    public ProductAccountRS obtainLoanProductByUniqueKey(String uniqueKey) {
        try {
            ProductAccount product = this.productAccountRepository.findByUniqueKey(uniqueKey);
            ProductAccountRS response = responseProductAccount(product);
            return response;
        } catch (RuntimeException rte) {
            throw new RuntimeException("Error al obtener loan product", rte);
        }
    }

    public ProductAccountRS obtainProductByUniqueKeyAndState(String uniqueKey,String state) {
        try {
            ProductAccount product = this.productAccountRepository.findByUniqueKeyAndState(uniqueKey,state);
            ProductAccountRS response = responseProductAccount(product);
            return response;
        } catch (RuntimeException rte) {
            throw new RuntimeException("Error al obtener loan product", rte);
        }
    }

    public List<ProductAccountTypeRS> obtainAllProductTypes(){
        try{
            List<ProductAccount> productTypes = this.productAccountRepository.findAllProductTypes();
            List<ProductAccountTypeRS> productTypeRSList = new ArrayList<>();
            for(ProductAccount productType : productTypes){
                productTypeRSList.add(this.responseProductAccountType(productType.getProductType()));
            }
            return productTypeRSList;
        }catch (RuntimeException rte){
            throw new RuntimeException("Error al obtener los tipos de productos",rte);
        }

    }

    


    public ProductAccount transformProductAccountRQ(ProductAccountRQ rq){
        ProductAccount productAccount = ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccount
                .builder()
                .name(rq.getName())
                .temporalityAccountStatement(rq.getTemporalityAccountStatement())
                .maxOverDraft(rq.getMaxOverDraft())
                .customerType(rq.getCustomerType())
                .minOpeningBalance(rq.getMinOpeningBalance())
                .minInterest(rq.getMinInterest())
                .maxInterest(rq.getMaxInterest())
                .state(rq.getState())
                .build();
        return productAccount;
    }

    public ProductAccountRS responseProductAccount(ProductAccount rq){
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
                .productType(rq.getProductType())
                .build();
        return productAccountRS;
    }

    public ProductAccountTypeRS responseProductAccountType(ProductAccountType rs){
        ProductAccountTypeRS productAccountTypeRS = ProductAccountTypeRS
                .builder()
                .name(rs.getName())
                .customerType(rs.getCustomerType())
                .superType(rs.getSuperType())
                .temporalityInterest(rs.getTemporalityInterest())
                .allowEarnInterest(rs.getAllowEarnInterest())
                .allowAccountStatement(rs.getAllowAccountStatement())
                .allowBranchTransactions(rs.getAllowBranchTransactions())
                .allowWithdrawal(rs.getAllowWithdrawal())
                .build();
        return productAccountTypeRS;
    }


    

    

    
}
