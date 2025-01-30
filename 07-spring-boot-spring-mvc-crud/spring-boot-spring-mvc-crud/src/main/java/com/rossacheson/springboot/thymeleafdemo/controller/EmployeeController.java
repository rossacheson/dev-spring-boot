package com.rossacheson.springboot.thymeleafdemo.controller;

import com.rossacheson.springboot.thymeleafdemo.entity.Employee;
import com.rossacheson.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        // get the employees from the db
        List<Employee> employees = employeeService.findAll();

        // add to the spring model
        model.addAttribute("employees", employees);

        // return template
        return "/employees/list-employees";
    }

    @GetMapping("/employee-form")
    public String showEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        // Post/Redirect/Get pattern helps prevent duplicate submissions
        return "redirect:/employees/list";
    }

}
