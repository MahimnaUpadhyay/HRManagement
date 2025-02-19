package com.HR.Management.Repository;

import com.HR.Management.Entity.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobModel, Long> {
}
