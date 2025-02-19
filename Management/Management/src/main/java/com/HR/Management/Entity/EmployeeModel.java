package com.HR.Management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long EmployeeID;
    @Column(name = "EmployeeName")
    private String EmployeeName;
    @Column(name = "EmployeeEmail")
    private String EmployeeEmail;
    @Column(name = "EmployeeJoiningDate")
    private String EmployeeJoiningDate;
    @Column(name = "EmployeeSalary")
    private long EmployeeSalary;
    @Column(name = "EmployeeRole")
    private String EmployeeRole;
    @Column(name = "EmployeeDepartment")
    private long EmployeeDepartment;
    @OneToMany
    @JoinColumn(name = "DepartmentID", referencedColumnName = "EmployeeDepartment")
    List<DepartmentModel> departmentModel;
}
