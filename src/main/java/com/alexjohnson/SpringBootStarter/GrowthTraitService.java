package com.alexjohnson.SpringBootStarter;

import com.alexjohnson.SpringBootStarter.enums.Status;
import com.alexjohnson.SpringBootStarter.enums.TraitRate;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GrowthTraitService {
  private final GrowthTraitRepository growthTraitRepository;
  private final GrowthAssessmentRepository growthAssessmentRepository;

  GrowthTraitData getByGrowthTraitId(Long id) {
    return growthTraitRepository.findByGrowthTraitId(id);
  }

  public void saveAllGrowthTraits() {
    List<GrowthAssessment> growthAssessmentTraits =
        growthAssessmentRepository.findAll();
    if (growthAssessmentTraits.size() == 0) {
      log.error("no growth assessment traits");
      return;
    }

    // otherwise, loop through. wherever the engineer rating is not unpracticed
    for (GrowthAssessment trait : growthAssessmentTraits) {
      GrowthTrait growthTrait = new GrowthTrait();
      if (trait.getEngineerRating() != TraitRate.UNPRACTICED) {
        growthTrait.setGrowthAssessmentId(trait.getGrowthAssessmentId());
        growthTrait.setStartDate(new Date());
        growthTrait.setStatus(Status.NEW);
        growthTrait.setAge(0);
        growthTrait.setCreatedAt(new Date());
        growthTrait.setUpdatedAt(new Date());

        log.info(growthTrait.toString());

        growthTraitRepository.save(growthTrait);
      }
    }
  }

  public List<GrowthPlanTrait>
  findByGrowthTraitParameters(String trait, String status, String mentee_rating,
                              String mentor_rating, String engineer_rating) {
    if (trait == null && status == null && mentee_rating == null &&
        mentor_rating == null && engineer_rating == null) {
      return growthTraitRepository.findAll();
    }
    return growthTraitRepository
        .findByTraitTypeOrStatusOrMenteeRatingOrMentorRatingOrEngineerRating(
            trait, status, mentee_rating, mentor_rating, engineer_rating);
  }

  public GrowthTrait moveTraitToNextStatus(Long id) {
    GrowthTrait growthTrait = growthTraitRepository.findById(id).orElseThrow(
        () -> new GrowthTraitNotFoundException());
    growthTrait.setStatus(growthTrait.getStatus().next());

    return growthTraitRepository.save(growthTrait);
  }

  public GrowthTrait moveTraitToPrevStatus(Long id) {
    GrowthTrait growthTrait = growthTraitRepository.findById(id).orElseThrow(
        () -> new GrowthTraitNotFoundException());
    growthTrait.setStatus(growthTrait.getStatus().prev());

    return growthTraitRepository.save(growthTrait);
  }
}
