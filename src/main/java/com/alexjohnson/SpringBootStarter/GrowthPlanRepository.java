package com.alexjohnson.SpringBootStarter;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface GrowthPlanRepository
    extends JpaRepository<GrowthPlan, String> {
  @RestResource(path = "findById") Optional<GrowthPlan> findById(GrowthPlan id);

  List<GrowthPlan> findAll();

  GrowthPlan save(GrowthPlan entity);
}
