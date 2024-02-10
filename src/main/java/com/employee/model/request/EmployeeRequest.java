package com.employee.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private String empFirstName;

    private String empLastName;

    private List<AddressRequest> address;

}
