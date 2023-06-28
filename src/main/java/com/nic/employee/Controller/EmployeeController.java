package com.nic.employee.Controller;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nic.employee.Entity.Employee;
import com.nic.employee.Entity.HistoryOfEmployee;
import com.nic.employee.Entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nic.employee.Repository.DesignationRepository;
import com.nic.employee.Repository.EmployeeHistoryRepository;
import com.nic.employee.Repository.EmployeeRepository;
import com.nic.employee.Repository.UserRepository;
import com.nic.employee.Service.EmployeeService;
import com.nic.employee.designation.Designation;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
	 private DesignationRepository designationRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EmployeeHistoryRepository employeeHistoryRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("/Nic")
    public String viewLogInPage() {
        return "login";
    }
    @GetMapping("/empLogin")
    public String viewEmployeeLogInPage() {
        return "employeelogin";
    }
    
    @PostMapping("/login")
    public String processLogin(Model model,User user) {
        User savedUser = userRepository.findByUsername(user.getUsername());
        
        if (savedUser != null && passwordEncoder.matches(user.getPassword(), savedUser.getPassword())) {
            return "redirect:/Employee";
        }

        else {
            model.addAttribute("error", "Invalid username or password");
            return "redirect:/Nic";
        }
    }
    
    @PostMapping("/employeelogin")
    public String login( Model model,User user) {
    	
        User suser = userRepository.findByUsername(user.getUsername());
        if (suser != null && passwordEncoder.matches(user.getPassword(), suser.getPassword())) {
        	
            Employee employee = employeeRepository.findById(suser.getId()).orElse(null);
            if (employee != null) {
            	Designation department = designationRepository.findById(employee.getDesignation()).orElse(null);
                if (department != null) {
                    employee.setDesignation(department.getField());
                }
            	 model.addAttribute("listEmployees", employeeService.getAllEmployees());
                model.addAttribute("employee", employee);
                return "employee"; 
            }
        }
        return "redirect:/empLogin"; 
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
    	User user= new User();
    	model.addAttribute("user", user);
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
    	employeeService.save(user);
        return "redirect:/empLogin";
        }
   
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
    	  employee.setCreatedAt(LocalDateTime.now());    
          employeeService.saveEmployee(employee);
    	 HistoryOfEmployee employeeHistorys = new HistoryOfEmployee();
    	
         employeeHistorys.setEmpid(employee.getId());
         employeeHistorys.setName(employee.getName());
         employeeHistorys.setAdminName(employee.getAdminname());
         employeeHistorys.setEndDate(employee.getEnddate());
         employeeHistorys.setStartDate(employee.getStartDate());
         employeeHistorys.setUpdateDate(employee.getCreatedAt());
         employeeHistorys.setDesignation(employee.getDesignation());
//         employeeHistorys.setEmpid(employeeHistorys.getEmpid());
         employeeHistoryRepository.save(employeeHistorys);
       
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
