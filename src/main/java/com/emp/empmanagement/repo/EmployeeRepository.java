package com.emp.empmanagement.repo;

import com.emp.empmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //TODO: add custom queries later if needed
    void deleteByEmpId(Long empId);
}
