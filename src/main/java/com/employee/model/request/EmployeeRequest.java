package com.employee.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private String empFirstName;

    private String empLastName;

    private AddressRequest address;
}
