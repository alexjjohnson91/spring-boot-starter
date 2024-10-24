package com.alexjohnson.SpringBootStarter;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface GrowthPlanRepository extends Repository<GrowthPlan, Long> {
  @RestResource(path = "findByGrowthPlanId")
  Optional<GrowthPlan> findByGrowthPlanId(GrowthPlan id);

  List<GrowthPlan> findAll();

  GrowthPlan save(GrowthPlan entity);
}
