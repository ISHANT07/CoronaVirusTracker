package com.example.CovidAlertService.dto;

import java.util.List;

public class AlertStatus {
    private String alertLevel;
    private List<String> measuresToBetaken;
    private StateData summaryData;

    public StateData getSummaryData() {
        return summaryData;
    }

    public void setSummaryData(StateData summaryData) {
        this.summaryData = summaryData;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public List<String> getMeasuresToBetaken() {
        return measuresToBetaken;
    }

    public void setMeasuresToBetaken(List<String> measuresToBetaken) {
        this.measuresToBetaken = measuresToBetaken;
    }
}
