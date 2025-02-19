package com.HR.Management.Controller;

import com.HR.Management.Entity.JobModel;
import com.HR.Management.Service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

//    GET method
    @GetMapping("/getJob")
    public List<JobModel> getAllJob(){
        return jobService.getAllJob();
    }

//    POST method
    @PostMapping("/addJob")
    public ResponseEntity<JobModel> addJob(@RequestBody JobModel jobModel){
        try {
            JobModel request = jobService.addJob(jobModel);
            return new ResponseEntity<>(request, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    PUT method
    @PutMapping("/updateJob/{jobID}")
    public ResponseEntity<JobModel> updateJob(@RequestBody JobModel jobModel, @PathVariable Long jobID){
        try {
            JobModel request = jobService.updateJob(jobID, jobModel);
            return new ResponseEntity<>(request, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    DELETE method
    @DeleteMapping("/deleteJob/{jobID}")
    public ResponseEntity<JobModel> deleteJob(@PathVariable Long jobID){
        try {
            JobModel request = jobService.deleteJob(jobID);
            return new ResponseEntity<>(request, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
