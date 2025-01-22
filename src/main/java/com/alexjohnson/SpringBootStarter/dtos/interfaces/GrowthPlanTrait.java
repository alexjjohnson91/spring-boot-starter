package com.alexjohnson.SpringBootStarter.dtos.interfaces;

import com.alexjohnson.SpringBootStarter.enums.Status;
import com.alexjohnson.SpringBootStarter.enums.TraitRate;
import com.alexjohnson.SpringBootStarter.enums.TraitType;
import org.springframework.beans.factory.annotation.Value;

public interface GrowthPlanTrait {
    @Value("#{target.growthAssessmentId}")
    String getGrowthAssessmentId();

    @Value("#{target.growthTraitId}")
    String getGrowthTraitId();

    @Value("#{target.detail}")
    String getDetail();

    @Value("#{target.trait_type}")
    TraitType getTraitType();

    @Value("#{target.menteeRating}")
    TraitRate getMenteeRating();

    @Value("#{target.mentorRating}")
    TraitRate getMentorRating();

    @Value("#{target.engineerRating}")
    TraitRate getEngineerRating();

    @Value("#{target.status}")
    Status getStatus();
}
