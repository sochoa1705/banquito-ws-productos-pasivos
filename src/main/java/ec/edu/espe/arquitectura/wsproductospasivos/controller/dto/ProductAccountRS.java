package ec.edu.espe.arquitectura.wsproductospasivos.controller.dto;

import java.math.BigDecimal;
import java.security.Timestamp;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductAccountRS {

    private String name;
    private String temporalityAccountStatement;
    private Boolean useCheckbook;
    private Boolean allowOverDraft;
    private Boolean allowTransferences;
    private BigDecimal maxOverDraft;
    private String customerType;
    private BigDecimal minOpeningBalance;
    private BigDecimal minInterest;
    private BigDecimal maxInterest;
    private String state;
    private Timestamp creationDate;
    private Timestamp activationDate;
    private Timestamp lastModifiedDate;    
    private Timestamp closedDate;
    
}
