package com.employee.controller;

import com.employee.model.request.EmployeeRequest;
import com.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/saveEmployee")
    public void saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.saveEmployee(employeeRequest);
    }
}
