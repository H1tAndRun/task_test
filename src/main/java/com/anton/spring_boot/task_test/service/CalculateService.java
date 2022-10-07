package com.anton.spring_boot.task_test.service;

import com.anton.spring_boot.task_test.dto.CalculateDTO;
import com.anton.spring_boot.task_test.utils.Holidays;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CalculateService {

    private static final BigDecimal AVG_NUMBER_DAYS_IN_MOTH = new BigDecimal("29.3");

    public BigDecimal calculateVocationPay(CalculateDTO calculateDTO) {
        int[] startDateArray = Arrays.stream(calculateDTO.getStartDate().split("[-.]"))
                .mapToInt(Integer::parseInt).toArray();
        int[] endDateArray = Arrays.stream(calculateDTO.getEndDate().split("[-.]"))
                .mapToInt(Integer::parseInt).toArray();
        LocalDate startDate = LocalDate.of(startDateArray[2], startDateArray[1], startDateArray[0]);//год, мес, день
        LocalDate endDate = LocalDate.of(endDateArray[2], endDateArray[1], endDateArray[0]);
        int allDaysRelax = countingDays(startDate, endDate);
        BigDecimal vocationPay =calculateDTO.getAvgSalary()
                .divide(AVG_NUMBER_DAYS_IN_MOTH,3,RoundingMode.CEILING)
                .multiply(new BigDecimal(allDaysRelax)).setScale(2, RoundingMode.CEILING);
        return vocationPay;
    }

    private int countingDays(LocalDate startRelaxDate, LocalDate endRelaxDate) {
        Set<String> holidaysSet = Arrays.stream(Holidays.values())
                .map(Holidays::getHolidayDate).collect(Collectors.toSet());
        int countDaysWeek = 0;
        if (startRelaxDate.isEqual(endRelaxDate)) {
            return 1;
        }
        while (startRelaxDate.isBefore(endRelaxDate) || startRelaxDate.equals(endRelaxDate)) {
            if (holidaysSet.contains(startRelaxDate.toString().substring(5, 10))) {
                startRelaxDate = startRelaxDate.plusDays(1);
                continue;
            }
            countDaysWeek++;
            startRelaxDate = startRelaxDate.plusDays(1);
        }
        return countDaysWeek;
    }
}
