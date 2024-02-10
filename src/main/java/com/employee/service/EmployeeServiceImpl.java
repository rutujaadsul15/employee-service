package com.employee.service;

import com.employee.model.request.EmployeeRequest;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    public void saveEmployee(EmployeeRequest employeeRequest) {
        System.out.println(employeeRequest);
    }
}
