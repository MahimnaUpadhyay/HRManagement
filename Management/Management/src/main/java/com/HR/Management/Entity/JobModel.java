package com.HR.Management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long JobID;
    private String JobRole;
    private String JobDescription;
    private String JobQualification;
    private long JobDepartment;
}
