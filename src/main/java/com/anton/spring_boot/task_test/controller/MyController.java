package com.anton.spring_boot.task_test.controller;

import com.anton.spring_boot.task_test.dto.CalculateDTO;
import com.anton.spring_boot.task_test.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final CalculateService calculateService;

    @Autowired
    public MyController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping("/calculate")
    public String calculationVacation(@RequestParam double avgSalary, @RequestParam String start, @RequestParam String end) {
        CalculateDTO calculateDTO = new CalculateDTO(avgSalary, start, end);
        return calculateService.calculateVocationPay(calculateDTO);
    }
}
