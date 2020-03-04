package com.spring.restapi.report.controller;

import com.spring.restapi.report.model.Report;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/report")
public class ReportController {

    @GetMapping("/{userId}")
    public ResponseEntity<?> init(@PathVariable String userId)
    {
        EntityModel<Report> em = new EntityModel<>(Report.builder().userId(userId).isAddUrl(false).build());
        return ResponseEntity.ok(em);
    }


    @GetMapping("/{channel}/{userId}")
    public ResponseEntity<?> reportToExcel(@PathVariable String channel, @PathVariable String userId)
    {
        //TODO channel 은 mail, sms, alim, asp, api, all

        EntityModel<Report> em = new EntityModel<>(Report.builder().userId(userId).isAddUrl(false).build());
        return ResponseEntity.ok(em);
    }
}
