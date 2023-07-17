package ec.edu.espe.arquitectura.wsproductospasivos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccount;

import java.util.List;


public interface ProductAccountRepository extends MongoRepository<ProductAccount,String> {
    ProductAccount findByUniqueKey(String uniqueKey);
    ProductAccount findByName(String name);
    List<ProductAccount> findByState(String state);
    @Query(value = "{'Product_Account_Type.superType':?0}",fields = "{'name':1,'customerType':1,'superType':1}")
    ProductAccount findProductAccountTypeBySuperType(String superType);
    
}
 