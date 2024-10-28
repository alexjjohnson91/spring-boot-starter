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

  public List<GrowthTrait> getGrowthTraitsByStatus(Status status) {
    String status_string = status.toString();
    return growthTraitRepository.findByStatus(status_string)
        .orElseThrow(() -> new GrowthTraitStatusNotFoundException(status));
  };
}
