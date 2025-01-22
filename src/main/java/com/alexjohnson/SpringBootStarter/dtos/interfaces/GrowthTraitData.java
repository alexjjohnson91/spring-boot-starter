package com.alexjohnson.SpringBootStarter.dtos.interfaces;

import com.alexjohnson.SpringBootStarter.enums.Status;
import com.alexjohnson.SpringBootStarter.enums.TraitType;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;

public interface GrowthTraitData {
    @Value("#{target.detail}")
    String getDetail();

    @Value("#{target.trait_type}")
    TraitType getTraitType();

    @Value("#{target.result}")
    String getResult();

    @Value("#{target.opportunity}")
    String getOpportunity();

    @Value("#{target.nextStep}")
    String getNextStep();

    @Value("#{target.goal}")
    String getGoal();

    @Value("#{target.startDate}")
    Date getStartDate();

    @Value("#{target.status}")
    Status getStatus();

    @Value("#{target.age}")
    int getAge();

    @Value("#{target.notes}")
    String getNotes();
}
