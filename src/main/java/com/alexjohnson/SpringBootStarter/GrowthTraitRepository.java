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
        WHERE STATUS = :status_state;
      """, nativeQuery = true)
  Optional<List<GrowthTrait>> findByStatus(String status_state);

  @Query(value = """
        SELECT *
        FROM GROWTH_TRAIT
        WHERE TRAIT_TYPE = :type;
      """, nativeQuery = true)
  Optional<List<GrowthTrait>> findByTraitType(String type);

  @Query(value = """
        SELECT *
        FROM GROWTH_TRAIT
        WHERE TRAIT_TYPE = :type
        AND STATUS = :status_state;
      """, nativeQuery = true)
  Optional<List<GrowthTrait>> findByTraitTypeAndStatus(String type, String status_state);
}
