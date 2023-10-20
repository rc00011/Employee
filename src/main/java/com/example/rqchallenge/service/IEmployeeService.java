package com.example.rqchallenge.service;

import com.example.rqchallenge.bean.CreateEmployee;
import com.example.rqchallenge.bean.Employee;
import com.example.rqchallenge.exception.CustomException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public interface IEmployeeService {
    public List<Employee> getAllEmployees() throws CustomException;
    public Employee getEmployeeById(String id) throws CustomException;
    public CreateEmployee createEmployee(Map<String, Object> employeeInput) throws CustomException;
    public String deleteEmployeeById(String id) throws CustomException;

    public List<Employee> getEmployeesByNameSearch(String searchString) throws CustomException;
    public Integer getHighestSalaryOfEmployees() throws CustomException;
    public List<String> getTopTenHighestEarningEmployeeNames() throws CustomException;
}
