package com.alexjohnson.SpringBootStarter.dtos;

import com.alexjohnson.SpringBootStarter.enums.TraitRate;
import com.alexjohnson.SpringBootStarter.enums.TraitType;
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
@Table(name = "growth_assessment")
public class GrowthAssessment {

    @Id
    private Long growthAssessmentId;

    private String category;
    private String attribute;
    private String detail;

    @Enumerated(EnumType.STRING)
    private TraitType traitType;

    @Enumerated(EnumType.STRING)
    private TraitRate menteeRating;

    @Enumerated(EnumType.STRING)
    private TraitRate mentorRating;

    @Enumerated(EnumType.STRING)
    private TraitRate engineerRating;

    @CreatedDate
    private Date createdAt;

    @LastModifiedBy
    private Date updatedAt;
}
