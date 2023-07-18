package ec.edu.espe.arquitectura.wsproductospasivos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.arquitectura.wsproductospasivos.model.productAccount;

import java.util.List;


public interface ProductAccountRepository extends MongoRepository<productAccount,String> {
    productAccount findByUniqueKey(String uniqueKey);
    productAccount findByUniqueKeyAndState(String uniqueKey,String state);
    List<productAccount> findAll();
    
    
}
 