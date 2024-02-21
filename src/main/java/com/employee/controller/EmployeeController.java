package com.employee.controller;
import com.employee.model.Employee;
import com.employee.model.request.EmployeeRequest;
import com.employee.model.request.EmployeeResponse;
import com.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());
    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/saveEmployee")
    public void saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        LOGGER.info("Employee Request saved");
        employeeService.saveEmployee(employeeRequest);
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeByPathVariable(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/getEmployee")
    public Employee getEmployeeByRequestParam(@RequestParam("id") Integer id) {
        return employeeService.getEmployee(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        LOGGER.info("Employee updated with patch mapping" + employee);
        return employeeService.updateEmployee(id, employee);
    }

    @GetMapping("/getEmployeeDetails/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeByName(@PathVariable Integer id) {
        EmployeeResponse employeeResponseDTO = employeeService.getEmployeeById(id);
        if (employeeResponseDTO != null) {
            return ResponseEntity.ok(employeeResponseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}