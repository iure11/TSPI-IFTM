package iftm.com.companycalculations.dto;

import java.math.BigDecimal;

public class AnnualWageDTO {
    private String firstName;
    private BigDecimal annualWage;

    public AnnualWageDTO(String firstName, BigDecimal annualWage) {
        this.firstName = firstName;
        this.annualWage = annualWage;
    }

    public AnnualWageDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public BigDecimal getAnnualWage() {
        return annualWage;
    }

    public void setAnnualWage(BigDecimal annualWage) {
        this.annualWage = annualWage;
    }
}
