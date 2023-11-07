package iftm.com.companycalculations.controller;

import iftm.com.companycalculations.dto.AnnualWageDTO;
import iftm.com.companycalculations.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class WageCalculationController {

    @PostMapping("/calculate-annual-wage")
    public ResponseEntity<AnnualWageDTO> calculateAnnualWage(@RequestBody EmployeeDTO employee) {

        BigDecimal annualWage = employee.getWage().multiply(new BigDecimal("12"));
        AnnualWageDTO response = new AnnualWageDTO(employee.getFirstName(), annualWage);


        return ResponseEntity.ok(response);
    }
}
