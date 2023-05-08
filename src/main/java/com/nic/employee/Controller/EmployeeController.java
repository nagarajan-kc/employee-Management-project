package com.nic.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nic.employee.Entity.Employee;
import com.nic.employee.Service.EmployeeService;

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
        model.addAttribute("employee", employee);
        return "newEmployee";
 }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

       employeeService.saveEmployee(employee);
       return "redirect:/Employee";
 } 

 @GetMapping("/Update/{id}")
 public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
  
  Employee employee = employeeService.getEmployeeById(id);
  model.addAttribute("employee", employee);
  return "updateemployee";
 }

 @GetMapping("/deleteEmployee/{id}")
public String deleteEmployee(@PathVariable (value = "id") int id) {
 
 this.employeeService.deleteEmployeeById(id);
 return "redirect:/Employee";

}
}
