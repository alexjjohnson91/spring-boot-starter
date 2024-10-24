package com.alexjohnson.SpringBootStarter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@Table(name = "growth_trait")
public class GrowthTrait {
  @Id
  private Long growthTraitId;

  private String result;
  private String opportunity;
  private String nextStep;
  private String growthAssessment;
  private String goal;
  private Date startDate;
  private String status;
  private int age;
  private String notes;
}
