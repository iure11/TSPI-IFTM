package iftm.com.companycalculations.feign;

import iftm.com.companycalculations.dto.AnnualWageDTO;
import iftm.com.companycalculations.dto.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "company-calculations", url = "http://localhost:8081")

public interface CompanyCalculationsClient {

    @PostMapping("/calculate-annual-wage")
    AnnualWageDTO calculateAnnualWage(EmployeeDTO employee);
}
