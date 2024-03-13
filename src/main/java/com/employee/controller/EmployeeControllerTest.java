package com.employee.controller;

import com.employee.model.request.EmployeeRequest;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeServiceImpl employeeService;
    @Test
    public void testSaveEmployee() {
        EmployeeRepository employeeRepositoryMock = mock(EmployeeRepository.class);
        // Arrange
        EmployeeRepository employeeRepositoryStub = new EmployeeRepositoryTestDouble();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepositoryStub);
        EmployeeRequest employeeRequest = new EmployeeRequest("John", "Doe", "john@example.com");

        // Act
        employeeService.saveEmployee(employeeRequest);

        // Assert
        EmployeeRepositoryTestDouble repositoryTestDouble = (EmployeeRepositoryTestDouble) employeeRepositoryStub;
        assertTrue(repositoryTestDouble.isSaveEmployeeCalled());
        assertEquals(employeeRequest, repositoryTestDouble.getSavedEmployeeRequest());
    }
    }
