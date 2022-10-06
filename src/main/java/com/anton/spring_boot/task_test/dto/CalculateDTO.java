package com.anton.spring_boot.task_test.dto;

public class CalculateDTO {

    private double avgSalary;
    private String startDate;
    private String endDate;

    public CalculateDTO(double avgSalary, String startDate, String endDate) {
        this.avgSalary = avgSalary;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
