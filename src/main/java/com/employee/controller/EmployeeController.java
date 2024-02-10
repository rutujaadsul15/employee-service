package com.employee.controller;

import com.employee.model.Employee;
import com.employee.model.request.EmployeeRequest;
import com.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/saveEmployee")
    public void saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.saveEmployee(employeeRequest);
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeByPathVariable( @PathVariable Integer id){
        return employeeService.getEmployee(id);
    }
    @GetMapping("/getEmployee")
    public Employee getEmployeeByRequestParam(@RequestParam("id") Integer id){
        return employeeService.getEmployee(id);
    }
}
