package com.alexjohnson.SpringBootStarter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

@Entity
@ToString
@Getter
@Setter
@Table(name = "growth_trait")
public class GrowthTrait {

  @Id private Long growthTraitId;

  private String result;
  private String opportunity;
  private String nextStep;
  private String growthAssessment;
  private String goal;
  private Date startDate;

  @Enumerated(EnumType.STRING) private Status status;

  private int age;
  private String notes;
  private String traitType;

  @CreatedDate private Date createdAt;

  @LastModifiedBy private Date updatedAt;
}
