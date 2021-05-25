package com.luv2code.springboot.thymeleaf.displayemployeesthymeleaf.controller;

import java.util.List;

import com.luv2code.springboot.thymeleaf.displayemployeesthymeleaf.entity.Employee;
import com.luv2code.springboot.thymeleaf.displayemployeesthymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for "/list"
//
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        //get the employees from the database
        List<Employee> employeeList = employeeService.findAll();

        theModel.addAttribute("employees", employeeList);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        //create the model attribute to bind the form data
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        //save the employee
        employeeService.save(theEmployee);
        //use a redirect to get back to the main page after saving
        return "redirect:/employees/list";
    }
    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        Employee theEmployee= employeeService.findById(theId);
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }
    @PostMapping ("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);
        return "redirect:/employees/list";

    }
}









