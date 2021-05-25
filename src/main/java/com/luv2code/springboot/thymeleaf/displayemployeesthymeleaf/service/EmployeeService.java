package com.luv2code.springboot.thymeleaf.displayemployeesthymeleaf.service;

import com.luv2code.springboot.thymeleaf.displayemployeesthymeleaf.entity.Employee;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee theEmployee);
    public void deleteById(int id);
}

