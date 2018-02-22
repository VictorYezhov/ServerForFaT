package com.fatserver.controlller;

import com.fatserver.entity.Job;
import com.fatserver.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping(value = "/jobs")
    public List<Job> getJobs(@RequestParam(name = "id") String id){
        System.out.println("Accepted id "+Long.decode(id));

        return  jobService.findJobsForUser(Long.decode(id));

    }

}
