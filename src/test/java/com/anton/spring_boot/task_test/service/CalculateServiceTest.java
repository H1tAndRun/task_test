package com.anton.spring_boot.task_test.service;

import com.anton.spring_boot.task_test.dto.CalculateDTO;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    @Test
    void calculateVocationPay() {
        CalculateService calculateService = new CalculateService();
        BigDecimal actual = calculateService
                .calculateVocationPay(new CalculateDTO(new BigDecimal(20000)
                        ,"20-01-2012"
                        ,"26-01-2012"));
        BigDecimal expected = new BigDecimal("4778.16");
        assertEquals(expected, actual);
    }
}