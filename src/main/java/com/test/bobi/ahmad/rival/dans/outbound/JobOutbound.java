package com.test.bobi.ahmad.rival.dans.outbound;

import com.test.bobi.ahmad.rival.dans.dto.response.JobResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "job-outbound", url = "http://dev3.dansmultipro.co.id")
public interface JobOutbound {

    @GetMapping("/api/recruitment/positions.json")
    List<JobResponse> getJobs();

    @GetMapping("/api/recruitment/positions/{id}")
    JobResponse getJobById(@PathVariable String id);
}
