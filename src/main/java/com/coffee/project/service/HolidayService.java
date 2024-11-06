package com.coffee.project.service;

import com.coffee.project.model.Holiday;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class HolidayService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String HOLIDAY_API_URL = "https://date.nager.at/Api/v2/PublicHolidays/{year}/KZ";

    @Cacheable("holidays")
    public boolean isHoliday(LocalDate date) {
        String url = HOLIDAY_API_URL.replace("{year}", String.valueOf(date.getYear()))
                .replace("{country}","Kazakhstan");

        List<Holiday> holidays = restTemplate.getForObject(url, List.class);

        return holidays != null && holidays.stream().anyMatch(holiday -> holiday.getDate().equals(date));
    }

}
