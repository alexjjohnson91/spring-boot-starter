package com.alexjohnson.SpringBootStarter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GrowthTraitService {
  private final GrowthTraitRepository growthTraitRepository;

  public GrowthTrait moveTraitToNextStatus(Long id) {
    GrowthTrait growthTrait = growthTraitRepository.findById(id).orElseThrow(
        () -> new GrowthTraitIdNotFoundException(id));
    growthTrait.setStatus(growthTrait.getStatus().next());

    return growthTraitRepository.save(growthTrait);
  }

  public GrowthTrait moveTraitToNextRating(Long id) {
    GrowthTrait growthTrait = growthTraitRepository.findById(id).orElseThrow(
        () -> new GrowthTraitIdNotFoundException(id));
    growthTrait.setMenteeRating(growthTrait.getMenteeRating().next());

    return growthTraitRepository.save(growthTrait);
  }
}
