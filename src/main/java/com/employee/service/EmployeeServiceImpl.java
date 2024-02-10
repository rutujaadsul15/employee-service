package com.employee.service;

import com.employee.model.Address;
import com.employee.model.Employee;
import com.employee.model.request.AddressRequest;
import com.employee.model.request.EmployeeRequest;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setEmpFirstName(employeeRequest.getEmpFirstName());
        employee.setEmpLastName(employeeRequest.getEmpLastName());

         List<Address> addressList = new ArrayList<>();
        employeeRequest.getAddress().forEach(addressRequest -> {
            Address address= new Address();
            address.setCity(addressRequest.getCity());
            address.setDistrict(addressRequest.getDistrict());
            address.setPinCode(addressRequest.getPinCode());
            addressList.add(address);
        });

        employee.setAddress(addressList);
        employeeRepository.save(employee);

    }

    @Override
    public Employee getEmployee(Integer id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        return byId.orElse(null);
    }
}
