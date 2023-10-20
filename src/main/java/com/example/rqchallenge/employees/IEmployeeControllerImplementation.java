package com.example.rqchallenge.employees;

import com.example.rqchallenge.bean.CreateEmployee;
import com.example.rqchallenge.bean.Employee;
import com.example.rqchallenge.exception.CustomException;
import com.example.rqchallenge.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class IEmployeeControllerImplementation implements IEmployeeController{

   @Autowired
   private IEmployeeService iEmployeeService;

    private static final Logger logger = LoggerFactory.getLogger(IEmployeeControllerImplementation.class);

    @Override
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() throws CustomException{
        logger.info("IEmployeeControllerImplementation : Get all employees");

        long beforeCallingService = System.currentTimeMillis();

        List<Employee> employeeList = iEmployeeService.getAllEmployees();

        long timeTaken = System.currentTimeMillis() - beforeCallingService;
        logger.info("Time taken to get all employees " + timeTaken);

        return ResponseEntity.ok(employeeList);
    }

    @Override
    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<Employee>> getEmployeesByNameSearch(@PathVariable String searchString) throws CustomException {
        logger.info("IEmployeeControllerImplementation : Get employees by search key");

        List<Employee> employeeList = iEmployeeService.getEmployeesByNameSearch(searchString);

        return ResponseEntity.ok(employeeList);

    }

    @Override
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) throws CustomException {

        logger.info("IEmployeeControllerImplementation : Get employee by id");

        long beforeCallingService = System.currentTimeMillis();

        Employee employee = iEmployeeService.getEmployeeById(id);

        long timeTaken = System.currentTimeMillis() - beforeCallingService;
        logger.info("Time taken to get employee by id " + timeTaken);

        return ResponseEntity.ok((Employee)employee);

    }

    @Override
    @GetMapping("/highestSalary")
    public ResponseEntity<Integer> getHighestSalaryOfEmployees() throws CustomException {

        logger.info("IEmployeeControllerImplementation : Get highest salary");

        Integer highestSalary = iEmployeeService.getHighestSalaryOfEmployees();

        return new ResponseEntity<>(highestSalary, HttpStatus.OK);

    }

    @Override
    @GetMapping("/topTenHighestEarningEmployeeNames")
    public ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames() throws CustomException {

        logger.info("IEmployeeControllerImplementation : Get top 10 highest earning employee names");

        List<String> topEarningEmployeeNames = iEmployeeService.getTopTenHighestEarningEmployeeNames();

        return new ResponseEntity<>(topEarningEmployeeNames, HttpStatus.OK);

    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<CreateEmployee> createEmployee(@RequestBody Map<String, Object> employeeInput) throws CustomException{
        logger.info("IEmployeeControllerImplementation : create employee");
        long beforeCallingService = System.currentTimeMillis();

        CreateEmployee employee = iEmployeeService.createEmployee(employeeInput);

        long totalTime = System.currentTimeMillis() - beforeCallingService;
        logger.info("IEmployeeControllerImplementation : time taken to create employee " + totalTime);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String id) throws CustomException{
        logger.info("IEmployeeControllerImplementation : delete employee");

        long beforeCallingService = System.currentTimeMillis();

        String status = iEmployeeService.deleteEmployeeById(id);
        long timeTaken = System.currentTimeMillis() - beforeCallingService;
        logger.info("Time taken to delete employee" + timeTaken);

        return ResponseEntity.ok((String) status);


    }
}
