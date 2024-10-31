package com.alexjohnson.SpringBootStarter;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GrowthTraitService {
  private final GrowthTraitRepository growthTraitRepository;

  public List<GrowthTrait>
  findByGrowthTraitParameters(String trait, String status, String mentee_rating,
                              String mentor_rating, String engineer_rating) {
    // log.info("Trait Type: ", trait.toString());
    // log.info("Status: ", status.toString());
    // log.info("Mentee Rating: ", mentee_rating.toString());
    // log.info("Mentor Rating: ", mentor_rating.toString());
    // log.info("Engineer Rating: ", engineer_rating.toString());
    log.warn("SERVICE");
    return growthTraitRepository
        .findByTraitTypeOrStatusOrMenteeRatingOrMentorRatingOrEngineerRating(
            trait, status, mentee_rating, mentor_rating, engineer_rating)
        .orElseThrow(() -> new GrowthTraitNotFoundException());
  }

  public GrowthTrait moveTraitToNextStatus(Long id) {
    GrowthTrait growthTrait = growthTraitRepository.findById(id).orElseThrow(
        () -> new GrowthTraitNotFoundException());
    growthTrait.setStatus(growthTrait.getStatus().next());

    return growthTraitRepository.save(growthTrait);
  }

  public GrowthTrait moveTraitToNextRating(Long id) {
    GrowthTrait growthTrait = growthTraitRepository.findById(id).orElseThrow(
        () -> new GrowthTraitNotFoundException());
    growthTrait.setMenteeRating(growthTrait.getMenteeRating().next());

    return growthTraitRepository.save(growthTrait);
  }
}
