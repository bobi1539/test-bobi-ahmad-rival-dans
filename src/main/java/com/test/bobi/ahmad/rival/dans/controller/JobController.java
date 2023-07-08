package com.test.bobi.ahmad.rival.dans.controller;

import com.test.bobi.ahmad.rival.dans.dto.response.JobResponse;
import com.test.bobi.ahmad.rival.dans.outbound.JobOutbound;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JobController {

    private final JobOutbound jobOutbound;

    @GetMapping
    public List<JobResponse> getJobs() {
        return jobOutbound.getJobs();
    }

    @GetMapping("/{id}")
    public JobResponse getJobById(@PathVariable String id){
        return jobOutbound.getJobById(id);
    }
}
