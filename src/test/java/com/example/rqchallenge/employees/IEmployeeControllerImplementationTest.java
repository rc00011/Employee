package com.example.rqchallenge.employees;

import com.example.rqchallenge.bean.CreateEmployee;
import com.example.rqchallenge.bean.Employee;
import com.example.rqchallenge.exception.CustomException;
import com.example.rqchallenge.enums.ErrorCode;
import com.example.rqchallenge.service.IEmployeeServiceImplementation;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class IEmployeeControllerImplementationTest {

    @InjectMocks
    private IEmployeeControllerImplementation iEmployeeController;
    @Mock
    private IEmployeeServiceImplementation iEmployeeService;

    @Test
    void testGetAllEmployeesSuccess() {
        try{
            Mockito.when(iEmployeeService.getAllEmployees()).thenReturn(getMockEmployeeList());
            iEmployeeController.getAllEmployees();
        }catch (Exception e)
        {
            fail();
        }
    }

    @Test
    void testGetAllEmployeesThrowsCustomException() {
        try{
            Mockito.when(iEmployeeService.getAllEmployees()).thenThrow(new CustomException(ErrorCode.EXCEPTION_IN_CALLING_EXTERNAL_API, "ErrorMessage"));
            iEmployeeController.getAllEmployees();
            fail();
        }catch (CustomException e)
        {
            assertTrue(true);
        }
    }

    @Test
    void testGetEmployeesByNameSearchSuccess(){
        try{
            Mockito.when(iEmployeeService.getEmployeesByNameSearch(Mockito.anyString())).thenReturn(getMockEmployeeList());
            iEmployeeController.getEmployeesByNameSearch("searchKey");
        }catch (Exception e)
        {
            fail();
        }
    }

    @Test
    void testGetEmployeesByNameSearchThrowsCustomException(){
        try{
            Mockito.when(iEmployeeService.getEmployeesByNameSearch(Mockito.anyString())).thenThrow(new CustomException(ErrorCode.EXCEPTION_IN_CALLING_EXTERNAL_API, "ErrorMessage"));
            iEmployeeController.getEmployeesByNameSearch("searchKey");
            fail();
        }catch (Exception e)
        {
            assertTrue(true);
        }
    }

    @Test
    void testGetEmployeeByIdSuccess(){
        try{
            Mockito.when(iEmployeeService.getEmployeeById(Mockito.anyString())).thenReturn(getMockEmployeeList().get(0));
            iEmployeeController.getEmployeeById("id");
        }catch (Exception e)
        {
            fail();
        }
    }

    @Test
    void testGetEmployeeByIdSuccessThrowsCustomException(){
        try{
            Mockito.when(iEmployeeService.getEmployeeById(Mockito.anyString())).thenThrow(new CustomException(ErrorCode.EXCEPTION_IN_CALLING_EXTERNAL_API, "ErrorMessage"));
            iEmployeeController.getEmployeeById("id");
            fail();
        }catch (Exception e)
        {
            assertTrue(true);
        }
    }

    @Test
    void testGetHighestSalaryOfEmployeesSuccess(){
        try{
            Mockito.when(iEmployeeService.getHighestSalaryOfEmployees()).thenReturn(1000);
            iEmployeeController.getHighestSalaryOfEmployees();
        }catch (Exception e)
        {
            fail();
        }
    }

    @Test
    void testGetHighestSalaryOfEmployeesThrowsCustomException(){
        try{
            Mockito.when(iEmployeeService.getHighestSalaryOfEmployees()).thenThrow(new CustomException(ErrorCode.EXCEPTION_IN_CALLING_EXTERNAL_API, "ErrorMessage"));
            iEmployeeController.getHighestSalaryOfEmployees();
            fail();
        }catch (Exception e)
        {
            assertTrue(true);
        }
    }

    @Test
    void testGetTopTenHighestEarningEmployeeNamesSuccess(){
        try{
            Mockito.when(iEmployeeService.getTopTenHighestEarningEmployeeNames()).thenReturn(getMockEmployeeNameList());
            iEmployeeController.getTopTenHighestEarningEmployeeNames();
        }catch (Exception e)
        {
            fail();
        }
    }

    @Test
    void testGetTopTenHighestEarningEmployeeNamesThrowsCustomException(){
        try{
            Mockito.when(iEmployeeService.getTopTenHighestEarningEmployeeNames()).thenThrow(new CustomException(ErrorCode.EXCEPTION_IN_CALLING_EXTERNAL_API, "ErrorMessage"));
            iEmployeeController.getTopTenHighestEarningEmployeeNames();
            fail();
        }catch (Exception e)
        {
            assertTrue(true);
        }
    }

    @Test
    void testCreateEmployeeSuccess(){
        try{
            Mockito.when(iEmployeeService.createEmployee(Mockito.anyMap())).thenReturn(getMockCreateEmployee());
            iEmployeeController.createEmployee(getMockMap());
        }catch (Exception e)
        {
            fail();
        }
    }

    @Test
    void testCreateEmployeeThrowsCustomException(){
        try{
            Mockito.when(iEmployeeService.createEmployee(Mockito.anyMap())).thenThrow(new CustomException(ErrorCode.EXCEPTION_IN_CALLING_EXTERNAL_API, "ErrorMessage"));
            iEmployeeController.createEmployee(getMockMap());
            fail();
        }catch (Exception e)
        {
            assertTrue(true);
        }
    }
    @Test
    void testDeleteEmployeeByIdSuccess(){
        try{
            Mockito.when(iEmployeeService.deleteEmployeeById(Mockito.anyString())).thenReturn("success");
            iEmployeeController.deleteEmployeeById("id");
        }catch (Exception e)
        {
            fail();
        }
    }

    @Test
    void testDeleteEmployeeByIdThrowsCustomException(){
        try{
            Mockito.when(iEmployeeService.deleteEmployeeById(Mockito.anyString())).thenThrow(new CustomException(ErrorCode.EXCEPTION_IN_CALLING_EXTERNAL_API, "ErrorMessage"));
            iEmployeeController.deleteEmployeeById("id");
            fail();
        }catch (Exception e)
        {
            assertTrue(true);
        }
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

    private List<String> getMockEmployeeNameList(){

        List<String> nameList = new ArrayList<>();

        nameList.add("employee1");
        nameList.add("employee2");

        return nameList;

    }

    private Map<String, Object> getMockMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name", "e1");
        map.put("age", 12);

        return map;
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
