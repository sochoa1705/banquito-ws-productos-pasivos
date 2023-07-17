package ec.edu.espe.arquitectura.wsproductospasivos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccount;
import ec.edu.espe.arquitectura.wsproductospasivos.service.ProductAccountService;

@RestController
@RequestMapping("/api/v1/product-account")
public class ProductAccountController {
    private final ProductAccountService service;

    public ProductAccountController(ProductAccountService service) {
        this.service = service;
    }

    @GetMapping("/{uniqueKey}")
    public ResponseEntity<ProductAccount> findByUniqueKey(@PathVariable("uniqueKey") String uniqueKey) {
        ProductAccount rs = this.service.obtainByUniqueKey(uniqueKey);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ProductAccount> findByName(@PathVariable("name") String name) {
        ProductAccount rs = this.service.obtainByName(name);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<ProductAccount>> findByState(@PathVariable("state") String state) {
        List<ProductAccount> rs = this.service.obtainByState(state);
        return ResponseEntity.ok(rs);
    }
    
    @GetMapping("/product-account/{superType}")
    public ResponseEntity<ProductAccount> findProductAccountBySuperType(@PathVariable("superType") String superType){
         ProductAccount rs = this.service.obtainBySuperType(superType);
         return ResponseEntity.ok(rs);
    }
}
