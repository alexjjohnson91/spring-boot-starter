package com.alexjohnson.SpringBootStarter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GrowthTraitRepository
    extends JpaRepository<GrowthTrait, Long> {
  @Query(value = """
        SELECT *
        FROM GROWTH_TRAIT
        WHERE STATUS = :status;
      """, nativeQuery = true)
  Optional<List<GrowthTrait>> findByStatus(String status);
}
