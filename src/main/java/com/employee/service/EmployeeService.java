package com.employee.service;

import com.employee.CustomException.NoCompanyExistException;
import com.employee.model.CompanyDTO;
import com.employee.model.Employee;
import com.employee.model.request.EmployeeRequest;
import com.employee.model.request.EmployeeResponse;

public interface EmployeeService {
     void saveEmployee(EmployeeRequest employeeRequest);

    Employee getEmployee(Integer id);

    Employee updateEmployee(Integer id, Employee employee);

    EmployeeResponse getEmployeeById(Integer id) throws NoCompanyExistException;

}
