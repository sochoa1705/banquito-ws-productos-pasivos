package ec.edu.espe.arquitectura.wsproductospasivos.controller;

import java.util.List;

import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountTypeRS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountRS;
import ec.edu.espe.arquitectura.wsproductospasivos.service.ProductAccountService;

@RestController
@RequestMapping("/api/v1/product-account")
public class ProductAccountController {
    private final ProductAccountService service;

    public ProductAccountController(ProductAccountService service) {
        this.service = service;
    }

    @GetMapping("/{uniqueKey}")
    public ResponseEntity<ProductAccountRS> findByUniqueKey(@PathVariable("uniqueKey") String uniqueKey) {
        ProductAccountRS rs = this.service.obtainLoanProductByUniqueKey(uniqueKey);
        return ResponseEntity.ok(rs);
    }

    
    @GetMapping("/all")
    public ResponseEntity<List<ProductAccountRS>> getAll(){
        List<ProductAccountRS> products = this.service.getAllProductService();
        return ResponseEntity.ok(products);
    }
    
    @GetMapping("/{uniqueKey}/{state}")
    public ResponseEntity<ProductAccountRS> obtainByUniqueKeyAndState(@PathVariable("uniqueKey") String uniqueKey,
            @PathVariable("state") String state) {
        if (state.equals("ACT")) {
            ProductAccountRS productAccountRS = this.service.obtainProductByUniqueKeyAndState(uniqueKey, state);
            return ResponseEntity.ok(productAccountRS);
        }else return ResponseEntity.notFound().build();

    }

    @GetMapping("/types")
    public ResponseEntity<List<ProductAccountTypeRS>> obtainProductTypes(){
        List<ProductAccountTypeRS> productTypes = this.service.obtainAllProductTypes();
        return ResponseEntity.ok(productTypes);
    }

    
}
