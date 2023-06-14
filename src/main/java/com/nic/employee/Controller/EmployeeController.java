package com.nic.employee.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nic.employee.Entity.Employee;
import com.nic.employee.Service.EmployeeService;
import com.nic.employee.designation.Designation;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    
   
    @GetMapping("/Employee")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees()); 
        return "index";
    }

    @GetMapping("/newEmployeeForm")
    public String newEmployeeForm(Model model) {
        Employee employee = new Employee();
        List<Designation> designation = employeeService.getAllDesignation();
        model.addAttribute("designation", designation);
        model.addAttribute("employee", employee);
        model.addAttribute(designation);
        return "newEmployee";
 }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult,Model model) {
    	
    	if (bindingResult.hasErrors()) {  
    		  List<Designation> designation = employeeService.findAll();
    	        model.addAttribute("designation", designation);
    	       
             return "newEmployee";
         }
       employeeService.saveEmployee(employee);
       return "redirect:/Employee";
 } 

 @GetMapping("/Update/{id}")
 public String showFormForUpdate(@PathVariable ( value = "id") String id, Model model) {
  Employee employee = employeeService.getEmployeeById(id);
  model.addAttribute("employee", employee);
  List<Designation> designation = employeeService.getAllDesignation();
  model.addAttribute("designation", designation);
  return "updateemployee";
 }
 
 @GetMapping("/delete/{id}")
 public String showDeleteConfirmation(@PathVariable("id") String  id, Model model) {
     Employee employee = employeeService.getEmployeeById(id);
     model.addAttribute("employee", employee);
     return "deleteconfirmation";
 }

 @PostMapping("/delete/{id}")
 public String deleteEmployee(@PathVariable("id") String id) {
     employeeService.deleteEmployeeById(id);
     return "redirect:/Employee";
 }
}
