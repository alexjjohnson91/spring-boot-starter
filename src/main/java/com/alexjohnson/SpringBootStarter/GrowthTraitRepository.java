package com.alexjohnson.SpringBootStarter;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GrowthTraitRepository
    extends JpaRepository<GrowthTrait, Long> {
  Optional<GrowthTrait> findById(Long id);

  @Query(value = """
        SELECT *
        FROM GROWTH_TRAIT
        WHERE STATUS = :status;
      """, nativeQuery = true)
  Optional<List<GrowthTrait>> findByStatus(String status);

  @Query(value = """
        SELECT *
        FROM GROWTH_TRAIT
        WHERE TRAIT_TYPE = :type;
      """, nativeQuery = true)
  Optional<List<GrowthTrait>> findByTraitType(String type);
}
