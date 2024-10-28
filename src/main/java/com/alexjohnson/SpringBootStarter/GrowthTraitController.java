package com.alexjohnson.SpringBootStarter;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GrowthTraitController {
  private final GrowthTraitRepository growthTraitRepository;
  private final GrowthTraitService growthTraitService;

  @GetMapping("/growth-traits")
  List<GrowthTrait> all() {
    return growthTraitRepository.findAll();
  }

  @GetMapping(path = "/growth-traits", params = {"id"})
  GrowthTrait one(@RequestParam(name = "id") Long id) {
    return growthTraitRepository.findById(id).orElseThrow(
        () -> new GrowthTraitIdNotFoundException(id));
  }

  @GetMapping(path = "/growth-traits", params = {"status"})
  List<GrowthTrait>
  getGrowthTraitsByStatus(@RequestParam(name = "status") Status status) {
    return growthTraitService.getGrowthTraitsByStatus(status);
  }

  @GetMapping(path = "/growth-traits", params = {"trait_type"})
  List<GrowthTrait> getGrowthTraitsByTraitType(
      @RequestParam(name = "trait_type") String trait_type) {
    return growthTraitRepository.findByTraitType(trait_type)
        .orElseThrow(() -> new GrowthTraitTypeNotFoundException(trait_type));
  }

  @GetMapping(path = "/growth-traits", params = {"trait_type", "status"})
  List<GrowthTrait> getGrowthTraitsByTraitTypeAndStatus(
      @RequestParam(name = "trait_type") String trait_type,
      @RequestParam(name = "status") Status status) {
    return growthTraitRepository.findByTraitTypeAndStatus(trait_type, status);
  }
}
