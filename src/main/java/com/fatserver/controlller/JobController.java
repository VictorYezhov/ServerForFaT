package com.fatserver.controlller;

import com.fatserver.entity.Job;
import com.fatserver.entity.User;
import com.fatserver.service.JobService;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/jobs")
    public List<Job> getJobs(@RequestParam(name = "id") String id){
        System.out.println("Accepted id "+Long.decode(id));

        return  jobService.findJobsForUser(Long.decode(id));

    }

    @PostMapping(value = "/sendNewJob{id}")
    public String updateJobs(@RequestBody JobForm job, @PathVariable Long id){
        Job j = jobService.findJobByName(job.getName());
        if(j!=null){
            User user = userService.findOne(id);
            user.getJobs().add(j);
            j.getUserListJob().add(user);
            userService.update(user);
            jobService.update(j);
        }else {
            User user = userService.findOne(id);
            Job job_user = new Job(job);
            user.getJobs().add(job_user);
            job_user.getUserListJob().add(user);
            userService.update(user);
            jobService.update(job_user);
        }
        //jobService.update(new Job(job));

        return "OK";
    }

}
