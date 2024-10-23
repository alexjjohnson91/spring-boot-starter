package com.alexjohnson.SpringBootStarter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@ToString
@Getter
@Setter
@Table(name = "growth_plan")
public class GrowthPlan {

  @Id @GeneratedValue(strategy = GenerationType.UUID) private String id;
  private String result;
  private String opportunity;
  private String nextStep;
  private String growthAssessment;
  private String goal;
  private Date startDate;
  private String status;
  private int age;
  private String notes;

  @CreatedDate private Instant createdAt;

  @LastModifiedDate private Instant updatedAt;
}
