package com.HR.Management.Service;

import com.HR.Management.Entity.EmployeeModel;
import com.HR.Management.Repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

//    Get All Employees
    public List<EmployeeModel> getAllEmployee(){
        return employeeRepository.findAll();
    }

//    Add Employee
    public EmployeeModel addEmployee(EmployeeModel employeeModel){
        return employeeRepository.save(employeeModel);
    }

//    Update Employee
    public EmployeeModel updateEmployee(@PathVariable Long employeeID, EmployeeModel employeeModel){
        Optional<EmployeeModel> existingEmployee = employeeRepository.findById(employeeID);
        if (existingEmployee.isPresent()){
            existingEmployee.get();
            return employeeRepository.save(employeeModel);
        } else {
            throw new EntityNotFoundException("Employee with ID " + employeeID + " does not exist");
        }
    }

//    Delete Employee
    public EmployeeModel deleteEmployee(@PathVariable Long employeeID){
        Optional<EmployeeModel> existingEmployee = employeeRepository.findById(employeeID);
        if (existingEmployee.isPresent()){
            employeeRepository.deleteById(employeeID);
            return existingEmployee.get();
        } else {
            throw new EntityNotFoundException("Employee with ID " + employeeID + " does not exist");
        }
    }
}
