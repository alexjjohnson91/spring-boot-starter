package com.alexjohnson.SpringBootStarter;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class GrowthPlan {
  // Where is the Opportunity
  String opportunity;
  // Next Step in Growth
  String nextStep;
  // What we want to Achieve-Growth Assessment
  String growthAssessment;
  // Goal/Target
  String goal;
  // Start Date
  Date startDate;
  // Status
  String status;
  // Age
  int age;

  public GrowthPlan(String opportunity, String nextStep,
                    String growthAssessment, String goal, Date startDate,
                    String status, int age) {
    this.opportunity = opportunity;
    this.nextStep = nextStep;
    this.growthAssessment = growthAssessment;
    this.goal = goal;
    this.startDate = startDate;
    this.status = status;
    this.age = age;
  }
}
