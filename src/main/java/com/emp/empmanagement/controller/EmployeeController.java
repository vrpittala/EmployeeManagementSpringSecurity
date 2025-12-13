package com.emp.empmanagement.controller;

import com.emp.empmanagement.entity.Employee;
import com.emp.empmanagement.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees(
            @RequestParam(required = false) Long empId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String department
    ){
        if(empId != null){
            return employeeService.getEmployeesById(empId);
        }
        else if(name != null){
            return employeeService.getEmployeesByName(name);
        }
        else if(department != null){
            return employeeService.getEmployeesByDepartment(department);
        }
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee addedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(addedEmployee, HttpStatus.OK);
    }
}
