package ec.edu.espe.arquitectura.wsproductospasivos.repository;

import ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ProductAccountRepository extends MongoRepository<ProductAccount,String> {
    @Override
    List<ProductAccount> findAll();
    ProductAccount findByUniqueKey(String uniqueKey);
    ProductAccount findByUniqueKeyAndState(String uniqueKey, String state);

    @Query(value = "{}", fields = "{'productType': 1}")
    List<ProductAccount> findAllProductTypes();

    
}
 