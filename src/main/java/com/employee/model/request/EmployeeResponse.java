package com.employee.model.request;

import com.employee.model.Address;
import com.employee.model.CompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

    private Integer empId;

    private String empFirstName;

    private String empLastName;

    private List<Address> address;

   private CompanyDTO companyDTO;
}
