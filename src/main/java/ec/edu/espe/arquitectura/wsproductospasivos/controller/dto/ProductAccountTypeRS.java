package ec.edu.espe.arquitectura.wsproductospasivos.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductAccountTypeRS {
    private String name;
    private String customerType;
    private String superType;
    private String temporalityInterest;
}