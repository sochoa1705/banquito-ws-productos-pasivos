package ec.edu.espe.arquitectura.wsproductospasivos.service;

import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountRS;
import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountTypeRS;
import ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccount;
import ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccountType;
import ec.edu.espe.arquitectura.wsproductospasivos.repository.ProductAccountRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductAccountServiceTests {
    @Mock
    private ProductAccountRepository productAccountRepository;

    @InjectMocks
    private ProductAccountService productAccountService;


    @Test
    public void ProductAccountService_ObtainLoanProductByUniqueKey_ReturnsProductAccountRS(){
        String uniqueKey = "c256f1b7-1c47-4b94-b7aa-00a17273d118";
        ProductAccountType productAccountType = new ProductAccountType("PERSONAL CURRENT ACCOUNT", "NAT", "DEP", "N/A", false, true, true, true);
        ProductAccount productAccount = new ProductAccount(null, "c256f1b7-1c47-4b94-b7aa-00a17273d118", "BASIC SAVINGS PERSONAL ACCOUNT", "MONTHLY"
                , false, false, true, new BigDecimal(0), "NAT",new BigDecimal(10), new BigDecimal("0.1"), new BigDecimal("0.2")
                ,"ACT", new Date(),new Date(), new Date(), new Date(), productAccountType);
        when(productAccountRepository.findByUniqueKey(uniqueKey)).thenReturn(productAccount);
        ProductAccountRS result = this.productAccountService.obtainLoanProductByUniqueKey(uniqueKey);
        Assertions.assertEquals("PERSONAL CURRENT ACCOUNT", result.getProductType().getName());

    }

    @Test(expected = RuntimeException.class)
    public void testObtainLoanProductByUniqueKeyFailure() {
        when(productAccountRepository.findByUniqueKey(anyString())).thenThrow(new RuntimeException());
        productAccountService.obtainLoanProductByUniqueKey("nonExistentKey");
    }

    @Test
    public void ProductAccountService_ObtainAllProductTypes_ReturnsProductAccountTypeRS(){
        ProductAccountType productAccountType = new ProductAccountType("PERSONAL CURRENT ACCOUNT", "NAT", "DEP", "N/A", false, true, true, true);
        ProductAccount productAccount = new ProductAccount(null, "c256f1b7-1c47-4b94-b7aa-00a17273d118", "BASIC SAVINGS PERSONAL ACCOUNT", "MONTHLY"
                , false, false, true, new BigDecimal(0), "NAT",new BigDecimal(10), new BigDecimal("0.1"), new BigDecimal("0.2")
                ,"ACT", new Date(),new Date(), new Date(), new Date(), productAccountType);
        List<ProductAccount> productAccountTypes = new ArrayList<>();
        productAccountTypes.add(productAccount);
        when(productAccountRepository.findAllProductTypes()).thenReturn(productAccountTypes);
        List<ProductAccountTypeRS> result = this.productAccountService.obtainAllProductTypes();
        Assertions.assertEquals(1, result.size());
    }

    @Test(expected = RuntimeException.class)
    public void testObtainAllProductTypesFailure() {
        when(productAccountRepository.findAllProductTypes()).thenThrow(new RuntimeException());
        productAccountService.obtainAllProductTypes();
    }

}
