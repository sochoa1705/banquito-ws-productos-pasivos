package ec.edu.espe.arquitectura.wsproductospasivos.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "productAccount")
public class ProductAccount {
    @Id
    private String id;
    @Indexed(unique = true)
    private String uniqueKey;
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
    private ProductAccountType productType;
}
