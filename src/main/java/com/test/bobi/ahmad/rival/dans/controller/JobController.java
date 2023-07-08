package com.test.bobi.ahmad.rival.dans.controller;

import com.test.bobi.ahmad.rival.dans.constant.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JobController {

    @GetMapping
    public Operation getJobs(){
        return Operation.INSERTED;
    }
}
