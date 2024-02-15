package com.employee.controller;

import com.employee.CustomException.NoCompanyExistException;
import com.employee.model.CompanyDTO;
import com.employee.model.Employee;
import com.employee.model.request.EmployeeRequest;
import com.employee.model.request.EmployeeResponse;
import com.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }
    @GetMapping("/getEmployeeDetails/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeByName(@PathVariable Integer id) throws NoCompanyExistException {
        EmployeeResponse employeeResponseDTO = employeeService.getEmployeeById(id);
        if (employeeResponseDTO != null) {
            return ResponseEntity.ok(employeeResponseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    }