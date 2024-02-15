package com.employee.service;

import com.employee.CustomException.NoCompanyExistException;
import com.employee.model.Address;
import com.employee.model.CompanyDTO;
import com.employee.model.Employee;
import com.employee.model.request.EmployeeRequest;
import com.employee.model.request.EmployeeResponse;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public void saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setEmpFirstName(employeeRequest.getEmpFirstName());
        employee.setEmpLastName(employeeRequest.getEmpLastName());
        employee.setCompanyName(employeeRequest.getCompanyName());
        List<Address> addressList = new ArrayList<>();
        employeeRequest.getAddress().forEach(addressRequest -> {
            Address address = new Address();
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

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if (byId.isPresent()) {
            Employee existingEmployee = byId.get();
            BeanUtils.copyProperties(employee, existingEmployee, "empId");
            return employeeRepository.save(existingEmployee);
        } else {
            return null;
        }
    }

    @Override
    public EmployeeResponse getEmployeeById(Integer id) throws NoCompanyExistException {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            // Call company microservice to get company details
            String companyServiceUrl = "http://localhost:8083/company/getCompany/" + employee.getCompanyName();

            CompanyDTO companyDTO = restTemplate.getForObject(companyServiceUrl, CompanyDTO.class);
            if(companyDTO==null){
                throw new NoCompanyExistException("No company found  with this name " +employee.getCompanyName());
            }
            // Create EmployeeResponseDTO object with employee and company details
            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setEmpId(employee.getEmpId());
            employeeResponse.setEmpFirstName(employee.getEmpFirstName());
            employeeResponse.setEmpLastName(employee.getEmpLastName());
            employeeResponse.setCompanyDTO(companyDTO);
            List<Address> addressList = new ArrayList<>();
            employee.getAddress().forEach(empAddress -> {
                Address address = new Address();
                address.setCity(empAddress.getCity());
                address.setDistrict(empAddress.getDistrict());
                address.setPinCode(empAddress.getPinCode());
                addressList.add(address);
            });

            employeeResponse.setAddress(addressList);

            return employeeResponse;
        } else {
            return null;
        }
    }

}


