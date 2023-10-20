package com.example.rqchallenge.service;

import com.example.rqchallenge.bean.*;
import com.example.rqchallenge.enums.ErrorCode;
import com.example.rqchallenge.exception.CustomException;
import com.example.rqchallenge.utils.APIUtils;
import com.example.rqchallenge.utils.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

@SpringBootTest
public class IEmployeeServiceImplementationTest {

    @InjectMocks
    private IEmployeeServiceImplementation iEmployeeServiceImplementation;

    @Mock
    private APIUtils apiUtils;

    @Mock
    private JsonUtils jsonUtils;

    @Test
    void testGetAllEmployeesSuccess(){
        try {
            when(apiUtils.get(Mockito.anyString())).thenReturn("value");
            when(jsonUtils.jsonToEmployeesResponse(Mockito.any())).thenReturn(getMockEmployeesResponse());

            iEmployeeServiceImplementation.getAllEmployees();
        } catch (CustomException e) {
           fail();
        }
    }

    @Test
    void testGetAllEmployeesWithNullResponse(){
        try {
            when(apiUtils.get(Mockito.anyString())).thenReturn("value");
            when(jsonUtils.jsonToEmployeesResponse(Mockito.any())).thenReturn(null);

            iEmployeeServiceImplementation.getAllEmployees();
            fail();
        } catch (CustomException e) {
            assertTrue(true);
        }
    }

    @Test
    void testGetEmployeeByIdSuccess(){
        try {
            when(apiUtils.get(Mockito.anyString())).thenReturn("value");
            when(jsonUtils.jsonToEmployeeResponse(Mockito.any())).thenReturn(getMockEmployeeResponse());

            iEmployeeServiceImplementation.getEmployeeById("id");
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    void testGetEmployeeByIdWithNullResponse(){
        try {
            when(apiUtils.get(Mockito.anyString())).thenReturn("value");
            when(jsonUtils.jsonToEmployeeResponse(Mockito.any())).thenReturn(null);

            iEmployeeServiceImplementation.getEmployeeById("id");
            fail();
        } catch (CustomException e) {
            assertTrue(true);
        }
    }

    @Test
    void testGetEmployeeByIdWithNullId(){
        try {
            when(apiUtils.get(Mockito.anyString())).thenReturn("value");
            when(jsonUtils.jsonToEmployeeResponse(Mockito.any())).thenReturn(getMockEmployeeResponse());

            iEmployeeServiceImplementation.getEmployeeById(null);
            fail();
        } catch (CustomException e) {
            assertTrue(true);
        }
    }

    @Test
    void testCreateEmployeeSuccess(){
        try {
            Mockito.when(jsonUtils.convertToJson(Mockito.any())).thenReturn("payLoad");
            when(apiUtils.post(Mockito.anyString(), Mockito.anyString())).thenReturn("value");
            when(jsonUtils.jsonToCreateEmployeeResponse(Mockito.any())).thenReturn(getMockCreateEmployeeResponse());

            iEmployeeServiceImplementation.createEmployee(getMockMap("name",10,10));
        } catch (CustomException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testCreateEmployeeValidationExceptions1(){
        try {
            iEmployeeServiceImplementation.createEmployee(getMockMap(null,null,null));
            fail();
        } catch (CustomException e) {
            assertTrue(true);
        }

    }

    @Test
    void testCreateEmployeeValidationExceptions2(){
        try {
            iEmployeeServiceImplementation.createEmployee(getMockMap(null,10,10));
               fail();
        } catch (CustomException e) {
            assertTrue(true);
        }

    }
    @Test
    void testCreateEmployeeValidationExceptions3(){
        try {
            iEmployeeServiceImplementation.createEmployee(getMockMap("name",10,null));
            fail();
        } catch (CustomException e) {
            assertTrue(true);
        }

    }
    @Test
    void testCreateEmployeeValidationExceptions4(){
        try {
            iEmployeeServiceImplementation.createEmployee(getMockMap("name",10,-10));
            fail();
        } catch (CustomException e) {
            assertTrue(true);
        }

    }
    @Test
    void testCreateEmployeeValidationExceptions5(){
        try {
            iEmployeeServiceImplementation.createEmployee(getMockMap("name",null,10));
           fail();
        } catch (CustomException e) {
            assertTrue(true);
        }

    }
    @Test
    void testCreateEmployeeValidationExceptions6(){
        try {
           iEmployeeServiceImplementation.createEmployee(getMockMap("name",101,10));
           fail();
        } catch (CustomException e) {
            assertTrue(true);
        }

    }
    @Test
    void testCreateEmployeeValidationExceptions7(){
        try {
             iEmployeeServiceImplementation.createEmployee(getMockMap("name",-10,10));
            fail();
        } catch (CustomException e) {
            assertTrue(true);
        }

    }

    @Test
    void testDeleteEmployeeSuccess(){
        try {
            iEmployeeServiceImplementation.deleteEmployeeById("id");
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    void testDeleteEmployeeException(){
        try {
            iEmployeeServiceImplementation.deleteEmployeeById(null);
            fail();
        } catch (CustomException e) {
            assertTrue(true);
        }
    }

    /*@Test
    void testGetEmployeesByNameSearchSuccess(){
        try {
            when(apiUtils.get(Mockito.anyString())).thenReturn("value");
            when(jsonUtils.jsonToEmployeesResponse(Mockito.any())).thenReturn(getMockEmployeesResponse());

            iEmployeeServiceImplementation.getHighestSalaryOfEmployees();
        } catch (CustomException e) {
            fail();
        }

    }*/

    private EmployeesResponse getMockEmployeesResponse(){

        return new EmployeesResponse("status", getMockEmployeeList(), "message");
    }

    private EmployeeResponse getMockEmployeeResponse(){

        return new EmployeeResponse("status", getMockEmployeeList().get(0), "message");
    }

    private CreateEmployeeResponse getMockCreateEmployeeResponse(){
        CreateEmployeeResponse createEmployeeResponse = new CreateEmployeeResponse();
        createEmployeeResponse.setData(getMockCreateEmployee());
        createEmployeeResponse.setMessage("message");
        createEmployeeResponse.setStatus("status");

        return createEmployeeResponse;
    }

    private Map<String, Object> getMockMap(String name, Integer age, Integer salary){
        Map<String,Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        map.put("salary", salary);

        return map;
    }

    private List<Employee> getMockEmployeeList(){

        List<Employee> employeeList = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("emp1");
        employee1.setSalary(10000);
        employee1.setAge(25);

        Employee employee2 = new Employee();
        employee1.setId(2);
        employee1.setName("emp2");
        employee1.setSalary(20000);
        employee1.setAge(35);

        employeeList.add(employee1);
        employeeList.add(employee2);

        return employeeList;

    }

    private CreateEmployee getMockCreateEmployee(){
        CreateEmployee employee1 = new CreateEmployee();
        employee1.setId(1);
        employee1.setName("emp1");
        employee1.setSalary(10000);
        employee1.setAge(25);
        return employee1;
    }
}
