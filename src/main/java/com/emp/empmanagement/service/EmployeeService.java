package com.emp.empmanagement.service;

import com.emp.empmanagement.entity.Employee;
import com.emp.empmanagement.repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesById(Long id){
        return employeeRepository.findAll().stream().filter(employee -> employee.getEmpId() == id).toList();
    }

    public List<Employee> getEmployeesByName(String name){
        return employeeRepository.findAll().stream().filter(employee -> employee.getName().toLowerCase().equals(name.toLowerCase())).toList();
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findAll().stream().filter(employee -> employee.getDepartment().toLowerCase() .equals(department.toLowerCase())).toList();
    }

    public Employee addEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    @Transactional
    public Employee updateEmployee(Employee employee){
        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getEmpId());
        if(existingEmployee.isPresent()){
            Employee emp = existingEmployee.get();
            emp.setName(employee.getName());
            emp.setDepartment(employee.getDepartment());
            emp.setSalary(employee.getSalary());
            return employeeRepository.save(emp);
        }
        return null;
    }

    @Transactional
    public void deleteEmployee(Employee employee){
        employeeRepository.deleteByEmpId(employee.getEmpId());
    }

}
