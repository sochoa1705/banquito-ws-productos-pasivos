package ec.edu.espe.arquitectura.wsproductospasivos.service;

import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountRQ;
import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountRS;
import ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccount;
import ec.edu.espe.arquitectura.wsproductospasivos.repository.ProductAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductAccountService {
    private final ProductAccountRepository productAccountRepository;


    public ProductAccountService(ProductAccountRepository productAccountRepository) {
        this.productAccountRepository = productAccountRepository;
    }


    public ProductAccount transformProductAccountRQ(ProductAccountRQ rq) {
        ProductAccount ProductAccount = ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccount
                .builder()
                .name(rq.getName())
                .temporalityAccountStatement(rq.getTemporalityAccountStatement())
                .maxOverDraft(rq.getMaxOverDraft())
                .customerType(rq.getCustomerType())
                .minOpeningBalance(rq.getMinOpeningBalance())
                .minInterest(rq.getMinInterest())
                .maxInterest(rq.getMaxInterest())
                .build();
        return ProductAccount;
    }

    public ProductAccountRS responseProductAccount(ProductAccount rq) {
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


    public ProductAccount obtainByUniqueKey(String uniqueKey) {
        return this.productAccountRepository.findByUniqueKey(uniqueKey);
    }

    public ProductAccount obtainByName(String name) {
        return this.productAccountRepository.findByName(name);
    }

    public List<ProductAccount> obtainByState(String state) {
        return this.productAccountRepository.findByState(state);
    }

    public ProductAccount obtainBySuperType(String superType) {
        return this.productAccountRepository.findProductAccountTypeBySuperType(superType);
    }
}
