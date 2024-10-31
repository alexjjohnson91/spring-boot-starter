package com.alexjohnson.SpringBootStarter;

import com.alexjohnson.SpringBootStarter.types.Status;
import com.alexjohnson.SpringBootStarter.types.TraitRate;
import com.alexjohnson.SpringBootStarter.types.TraitType;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GrowthTraitController {
  private final GrowthTraitRepository growthTraitRepository;
  private final GrowthTraitService growthTraitService;

  @GetMapping(path = "/growth-traits", params = {"id"})
  GrowthTrait one(@RequestParam(name = "id") Long id) {
    return growthTraitRepository.findById(id).orElseThrow(
        () -> new GrowthTraitNotFoundException());
  }

  @GetMapping(path = "/growth-traits")
  List<GrowthTrait> getGrowthTraitsByRatings(
      @RequestParam(name = "trait_type", required = false) TraitType trait_type,
      @RequestParam(name = "status", required = false) Status status,
      @RequestParam(name = "mentee_rating",
                    required = false) TraitRate mentee_rating,
      @RequestParam(name = "mentor_rating",
                    required = false) TraitRate mentor_rating,
      @RequestParam(name = "engineer_rating",
                    required = false) TraitRate engineer_rating) {
    log.info("controller called");
    if (trait_type == null && status == null && mentee_rating == null &&
        mentor_rating == null && engineer_rating == null) {
      return growthTraitRepository.findAll();
    }

    log.info("calling service");

    return growthTraitService.findByGrowthTraitParameters(
        trait_type != null ? trait_type.toString() : null,
        status != null ? status.toString() : null,
        mentee_rating != null ? mentee_rating.toString() : null,
        mentor_rating != null ? mentor_rating.toString() : null,
        engineer_rating != null ? engineer_rating.toString() : null);
  }

  @PatchMapping(path = "/growth-traits/{id}/next-status")
  GrowthTrait moveTraitToNextStatus(@PathVariable Long id) {
    return growthTraitService.moveTraitToNextStatus(id);
  }

  @PatchMapping(path = "/growth-traits/{id}/next-rating")
  GrowthTrait moveTraitToNextRating(@PathVariable Long id) {
    return growthTraitService.moveTraitToNextRating(id);
  }
}
