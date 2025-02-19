package com.HR.Management.Controller;

import com.HR.Management.Entity.DepartmentModel;
import com.HR.Management.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

//    Get Method
    @GetMapping("/getAllDepartments")
    public List<DepartmentModel> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

//    Post Method
    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentModel> addDepartment(@RequestBody DepartmentModel departmentModel){
        try {
            DepartmentModel request = departmentService.addDepartment(departmentModel);
            return new ResponseEntity<>(request, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    Put Method
    @PutMapping("/updateDepartment/{departmentID}")
    public ResponseEntity<DepartmentModel> updateDepartment(@PathVariable Long departmentID, @RequestBody DepartmentModel departmentModel){
        try {
            DepartmentModel request = departmentService.updateDepartment(departmentID, departmentModel);
            return new ResponseEntity<>(request, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    Delete Method
    @DeleteMapping("/deleteDepartment/{departmentID}")
    public ResponseEntity<DepartmentModel> deleteDepartment(@PathVariable Long departmentID){
        try {
            DepartmentModel request = departmentService.deleteDepartment(departmentID);
            return new ResponseEntity<>(request, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
