package com.example.CovidAlertService.service;

import com.example.CovidAlertService.dto.AlertStatus;
import com.example.CovidAlertService.dto.StateData;
import com.example.CovidAlertService.dto.SummaryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AlertService {

    @Autowired
    private Covid19DataProvide covid19DataProvide;

    public AlertStatus getAlertAboutState(String state) {
        AlertStatus alertStatus=new AlertStatus();
        StateData stateData=covid19DataProvide.getStateData(state);
        System.out.println(stateData);
        alertStatus.setSummaryData(stateData);
        if(stateData.getTotalConfirmed()<1000)
        {
            alertStatus.setAlertLevel("Green");
            alertStatus.setMeasuresToBetaken(Arrays.asList("Every Thing is Normal"));
        }
        else if(stateData.getTotalConfirmed()<10000) {
            alertStatus.setAlertLevel("Orange");
            alertStatus.setMeasuresToBetaken(Arrays.asList("Every Thing is Not Normal","Dont go outside"));
        }
        else
        {
            alertStatus.setAlertLevel("Red");
            alertStatus.setMeasuresToBetaken(Arrays.asList("Every Thing is Not Normal","Dont go outside","stay Calm"));
        }
        return alertStatus;
    }

    public SummaryData getOverAllSummary()
    {
        return covid19DataProvide.getOverAllSummaryData();
    }
}
