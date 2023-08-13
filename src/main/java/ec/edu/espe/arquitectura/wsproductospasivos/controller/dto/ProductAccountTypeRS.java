package ec.edu.espe.arquitectura.wsproductospasivos.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAccountTypeRS {
    private String name;
    private String customerType;
    private String superType;
    private String temporalityInterest;
    private Boolean allowEarnInterest;
    private Boolean allowAccountStatement;
    private Boolean allowBranchTransactions;
    private Boolean allowWithdrawal;
}
