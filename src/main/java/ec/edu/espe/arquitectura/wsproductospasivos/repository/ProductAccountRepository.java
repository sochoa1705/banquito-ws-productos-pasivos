package ec.edu.espe.arquitectura.wsproductospasivos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ec.edu.espe.arquitectura.wsproductospasivos.model.productAccount;

import java.util.List;


public interface ProductAccountRepository extends MongoRepository<productAccount,String> {
    productAccount findByUniqueKey(String uniqueKey);
    productAccount findByName(String name);
    List<productAccount> findByState(String state);
    @Query(value = "{'Product_Account_Type.superType':? 0}",fields = "{'name:'1,'customerType:'1,'superType.$':1}")
    productAccount findProductAccountTypeBySuperType(String superTipo);
    
}
 