package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeControllerrTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private EmployeeController employeeController;
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testGetEmployeeByRequestParam() throws Exception {
        // Mocking the service method
        Mockito.when(employeeService.getEmployee(Mockito.anyInt())).thenReturn(new Employee(/*provide necessary arguments*/));

        // Performing the request and asserting the response
        mockMvc.perform(MockMvcRequestBuilders.get("/getEmployee").param("id", "1"))
                .andExpect(status().isOk());;
    }
}
