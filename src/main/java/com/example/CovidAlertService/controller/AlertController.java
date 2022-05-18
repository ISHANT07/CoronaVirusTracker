package com.example.CovidAlertService.controller;

import com.example.CovidAlertService.dto.AlertStatus;
import com.example.CovidAlertService.dto.SummaryData;
import com.example.CovidAlertService.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/india/")
public class AlertController {

    @Autowired private  AlertService alertService;

    @GetMapping("/{state}")
    AlertStatus getAlertAboutState(@PathVariable String state)
    {
       // System.out.println(state);
  return alertService.getAlertAboutState(state);
    }

    @GetMapping("/summary")
    SummaryData getOverAllSummaryData()
    {
        return alertService.getOverAllSummary();
    }

}
