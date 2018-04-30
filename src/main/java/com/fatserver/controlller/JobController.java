package com.fatserver.controlller;

import com.fatserver.IncomingForms.JobForm;
import com.fatserver.entity.Job;
import com.fatserver.entity.User;
import com.fatserver.service.JobService;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Controller for processing requests that relate to the jobs\education of user
 */
@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @Autowired
    UserService userService;

    /**
     * Method returns list of all Jobs and Educational places for user with given id
     * @param id - user id
     * @return List<Job> list of jobs for user with id specified in params
     */
    @GetMapping(value = "/jobs")
    public List<Job> getJobs(@RequestParam(name = "id") String id){
        System.out.println("Accepted id "+Long.decode(id));

        return  jobService.findJobsForUser(Long.decode(id));

    }

    /**
     * Add`s to user with id, specified in params, new job\education
     * @param job - new job to add
     * @param id - users id
     * @return
     */
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

    @PostMapping(value = "/deleteItemFromJobList{id}")
    public String deleteItemFromJobList(@RequestBody Long id_user ,@PathVariable Long id){
        System.out.println(id);
        User u = userService.findOne(id_user);
        Job j = jobService.findOne(id);
        Set<Job> allJobs = u.getJobs();
        allJobs.remove(j);
        u.setJobs(allJobs);
        userService.update(u);
        return "OK";
    }

}
