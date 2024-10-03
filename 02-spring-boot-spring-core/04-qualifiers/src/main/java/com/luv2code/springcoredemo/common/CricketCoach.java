package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;
import com.luv2code.springcoredemo.common.Coach;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 mins!!!!!!";
    }
}
