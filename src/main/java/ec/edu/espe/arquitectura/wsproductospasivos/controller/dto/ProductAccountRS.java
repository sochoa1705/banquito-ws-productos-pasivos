package ec.edu.espe.arquitectura.wsproductospasivos.controller.dto;

import java.math.BigDecimal;
import java.util.Date;


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
    private Date creationDate;
    private Date activationDate;
    private Date lastModifiedDate;
    private Date closedDate;
    
}
