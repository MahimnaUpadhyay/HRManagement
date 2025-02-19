package com.HR.Management.Service;

import com.HR.Management.Entity.JobModel;
import com.HR.Management.Repository.JobRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

//    Get All Job
    public List<JobModel> getAllJob(){
        return jobRepository.findAll();
    }

//    Add Job
    public JobModel addJob(JobModel jobModel){
        return jobRepository.save(jobModel);
    }

//    Update Job
    public JobModel updateJob(@PathVariable Long jobID, JobModel jobModel){
        Optional<JobModel> existingJob = jobRepository.findById(jobID);

        if (existingJob.isPresent()){
            existingJob.get();
            return jobRepository.save(jobModel);
        } else {
            throw new EntityNotFoundException("Job with ID " + jobID + " does not exist");
        }
    }

//    Delete Job
    public JobModel deleteJob(@PathVariable Long jobID){
        Optional<JobModel> existingJob = jobRepository.findById(jobID);

        if (existingJob.isPresent()){
            jobRepository.deleteById(jobID);
            return existingJob.get();
        } else {
            throw new EntityNotFoundException("Job with ID " + jobID + " does not exist");
        }
    }
}
