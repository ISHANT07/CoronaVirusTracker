package com.example.CovidAlertService.service;


import com.example.CovidAlertService.dto.CovidAPIData;
import com.example.CovidAlertService.dto.StateData;
import com.example.CovidAlertService.dto.SummaryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class Covid19DataProvide {

    final String URL="https://api.rootnet.in/covid19-in/stats/latest";

    @Autowired
    RestTemplate restTemplate;


    StateData getStateData(String state)
    {
   CovidAPIData covidAPIData=restTemplate.getForObject(URL, CovidAPIData.class);

   //System.out.println(covidAPIData.getData());
  // covidAPIData.getCountryData().getRegional();
   return Arrays.stream( covidAPIData.getData().getRegional())
           .filter(e-> e.getLoc().equalsIgnoreCase(state))
           .findAny()
           .orElse(new StateData());
    }

    public SummaryData getOverAllSummaryData() {

        CovidAPIData covidAPIData=restTemplate.getForObject(URL, CovidAPIData.class);
        SummaryData summaryData =covidAPIData.getData().getSummary();
        summaryData.setUpdateTime(covidAPIData.getLastRefreshed());

        return summaryData;
    }



}
