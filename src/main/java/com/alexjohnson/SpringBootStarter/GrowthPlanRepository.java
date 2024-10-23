package com.alexjohnson.SpringBootStarter;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface GrowthPlanRepository extends JpaRepository<GrowthPlan, Long> {
  @RestResource(path = "findByGrowthPlanId")
  Optional<GrowthPlan> findByGrowthPlanId(GrowthPlan id);

  List<GrowthPlan> findAll();

  GrowthPlan save(GrowthPlan entity);
}
