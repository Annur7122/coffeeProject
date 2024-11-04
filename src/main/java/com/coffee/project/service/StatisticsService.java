package com.coffee.project.service;

import com.coffee.project.model.Statistics;
import com.coffee.project.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;



}
