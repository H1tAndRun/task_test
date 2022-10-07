package com.anton.spring_boot.task_test.dto;

import java.math.BigDecimal;

public class CalculateDTO {

    private BigDecimal avgSalary;
    private String startDate;
    private String endDate;

    public CalculateDTO(BigDecimal avgSalary, String startDate, String endDate) {
        this.avgSalary = avgSalary;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BigDecimal getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(BigDecimal avgSalary) {
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
