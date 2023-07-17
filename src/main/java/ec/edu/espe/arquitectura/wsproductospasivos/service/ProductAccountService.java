package ec.edu.espe.arquitectura.wsproductospasivos.service;

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

    public productAccount obtainByName(String name){
        return this.productAccountRepository.findByName(name);
    }

    public List<productAccount> obtainByState(String state){
        return this.productAccountRepository.findByState(state);
    }

    public productAccount obtainBySuperType(String superType){
        return this.productAccountRepository.findProductAccountTypeBySuperType(superType);
    }
}
