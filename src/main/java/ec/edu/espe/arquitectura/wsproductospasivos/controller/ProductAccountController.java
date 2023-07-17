package ec.edu.espe.arquitectura.wsproductospasivos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.wsproductospasivos.model.productAccount;
import ec.edu.espe.arquitectura.wsproductospasivos.service.ProductAccountService;

@RestController
@RequestMapping("/api/v1/product-account")
public class ProductAccountController {
    private final ProductAccountService service;

    public ProductAccountController(ProductAccountService service) {
        this.service = service;
    }

    @GetMapping("/{uniqueKey}")
    public ResponseEntity<productAccount> findByUniqueKey(@PathVariable("uniqueKey") String uniqueKey) {
        productAccount rs = this.service.obtainByUniqueKey(uniqueKey);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<productAccount> findByName(@PathVariable("name") String name) {
        productAccount rs = this.service.obtainByName(name);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<productAccount>> findByState(@PathVariable("state") String state) {
        List<productAccount> rs = this.service.obtainByState(state);
        return ResponseEntity.ok(rs);
    }
    
    @GetMapping("/product-account/{superType}")
    public ResponseEntity<productAccount> findProductAccountBySuperType(@PathVariable("superType") String superType){
         productAccount rs = this.service.obtainBySuperType(superType);
         return ResponseEntity.ok(rs);
    }
}
