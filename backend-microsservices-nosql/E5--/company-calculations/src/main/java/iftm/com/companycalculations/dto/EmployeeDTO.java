package iftm.com.companycalculations.dto;

import java.math.BigDecimal;

public class EmployeeDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String level;
    private BigDecimal wage;

    public EmployeeDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public BigDecimal getWage() {
        return wage;
    }

    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }

    public EmployeeDTO(String id, String firstName, String lastName, String level, BigDecimal wage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.wage = wage;
    }
}
