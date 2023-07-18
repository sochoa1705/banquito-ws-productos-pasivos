package ec.edu.espe.arquitectura.wsproductospasivos.controller.dto;

import java.math.BigDecimal;
import java.util.Date;


import ec.edu.espe.arquitectura.wsproductospasivos.model.ProductAccountType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductAccountRS {

    private String name;
    private String temporalityAccountStatement;
    private BigDecimal maxOverDraft;
    private String customerType;
    private BigDecimal minOpeningBalance;
    private BigDecimal minInterest;
    private BigDecimal maxInterest;
    private String state;
    private Date creationDate;
    private Date activationDate;
    private Date lastModifiedDate;
    private Date closedDate;
    private ProductAccountType productType;
    
}
