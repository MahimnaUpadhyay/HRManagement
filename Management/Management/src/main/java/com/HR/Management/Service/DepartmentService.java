package com.HR.Management.Service;

import com.HR.Management.Entity.DepartmentModel;
import com.HR.Management.Repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    public final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

//    Get All Departments
    public List<DepartmentModel> getAllDepartment(){
        return departmentRepository.findAll();
    }

//    Add Department
    public DepartmentModel addDepartment(DepartmentModel departmentModel){
        return departmentRepository.save(departmentModel);
    }

//    Update Department
    public DepartmentModel updateDepartment(@PathVariable Long departmentID, DepartmentModel departmentModel){
        Optional<DepartmentModel> existingDepartment = departmentRepository.findById(departmentID);

        if (existingDepartment.isPresent()){
            existingDepartment.get();
            return departmentRepository.save(departmentModel);
        } else {
            throw new EntityNotFoundException("Department of ID " + departmentID + " does not exists");
        }
    }

//    Delete Department
    public DepartmentModel deleteDepartment(@PathVariable Long departmentID){
        Optional<DepartmentModel> existingDepartment = departmentRepository.findById(departmentID);

        if (existingDepartment.isPresent()){
            departmentRepository.deleteById(departmentID);
            return existingDepartment.get();
        } else {
            throw new EntityNotFoundException("Department of ID " + departmentID + " does not exists");
        }
    }
}
