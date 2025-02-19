package com.HR.Management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Department")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long DepartmentID;
    @Column(name = "DepartmentName")
    private String DepartmentName;
    @Column(name = "DepartmentHead")
    private String DepartmentHead;
}
