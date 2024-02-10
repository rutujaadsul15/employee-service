package com.employee.service;

import com.employee.model.Employee;
import com.employee.model.request.EmployeeRequest;

public interface EmployeeService {
     void saveEmployee(EmployeeRequest employeeRequest);

    Employee getEmployee(Integer id);
}
