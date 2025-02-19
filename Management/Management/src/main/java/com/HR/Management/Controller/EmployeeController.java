package com.HR.Management.Controller;

import com.HR.Management.Entity.EmployeeModel;
import com.HR.Management.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

//    Get Method
    @GetMapping("/getAllEmployees")
    public List<EmployeeModel> getAllEmployee(){
        try {
            return employeeService.getAllEmployee();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    Post Method
    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeModel> addEmployee(@ModelAttribute EmployeeModel employeeModel){
        try{
            EmployeeModel request = employeeService.addEmployee(employeeModel);
            return new ResponseEntity<>(request, HttpStatus.CREATED);
        } catch (Exception e){
           throw new RuntimeException(e);
        }
    }

//    Put Method
    @PutMapping("/updateEmployee/{employeeID}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable Long employeeID, @RequestBody EmployeeModel employeeModel){
        try{
            EmployeeModel request = employeeService.updateEmployee(employeeID, employeeModel);
            return new ResponseEntity<>(request, HttpStatus.OK);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

//    Delete Method
    @DeleteMapping("/deleteEmployee/{employeeID}")
    public ResponseEntity<EmployeeModel> deleteEmployee(@PathVariable Long employeeID){
        try {
            EmployeeModel request = employeeService.deleteEmployee(employeeID);
            return new ResponseEntity<>(request, HttpStatus.OK);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
