package ec.edu.espe.arquitectura.wsproductospasivos.controller;

import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountRS;
import ec.edu.espe.arquitectura.wsproductospasivos.controller.dto.ProductAccountTypeRS;
import ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccount;
import ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccountType;
import ec.edu.espe.arquitectura.wsproductospasivos.service.ProductAccountService;
import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(ProductAccountController.class)
@AutoConfigureMockMvc(addFilters = false)
@RunWith(MockitoJUnitRunner.class)
public class ProductAccountControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductAccountService productAccountService;

    @Test
    public void ProductAccountController_ObtainProductTypes_ReturnsProductAccountTypeRS() throws Exception {
        List<ProductAccountTypeRS> expectedTypes = new ArrayList<>();
        expectedTypes.add(new ProductAccountTypeRS("PERSONAL CURRENT ACCOUNT", "NAT", "DEP", "N/A", false, true, true, true));
        when(productAccountService.obtainAllProductTypes()).thenReturn(expectedTypes);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product-account/types")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", CoreMatchers.is("PERSONAL CURRENT ACCOUNT")));
    }
}
