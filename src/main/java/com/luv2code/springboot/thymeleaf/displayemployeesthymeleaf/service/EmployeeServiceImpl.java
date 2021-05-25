package com.luv2code.springboot.thymeleaf.displayemployeesthymeleaf.service;

import com.luv2code.springboot.thymeleaf.displayemployeesthymeleaf.controller.EmployeeNotFound;
import com.luv2code.springboot.thymeleaf.displayemployeesthymeleaf.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleaf.displayemployeesthymeleaf.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeDAO;

    @Autowired
    public EmployeeServiceImpl (EmployeeRepository employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAllByOrderByFirstName();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result= employeeDAO.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        else{
            throw new EmployeeNotFound("Not found the employee with id "+ id);
        }

    }

    @Override
    public void save(Employee theEmployee) {
        employeeDAO.save(theEmployee);
    }

    @Override
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
