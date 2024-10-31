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
        WHERE
          TRAIT_TYPE = COALESCE(:type, TRAIT_TYPE) AND
          STATUS = COALESCE(:status_state, STATUS) AND
          MENTEE_RATING = COALESCE(:mentee_rating_string, MENTEE_RATING) AND
          MENTOR_RATING = COALESCE(:mentor_rating_string, MENTOR_RATING) AND
          ENGINEER_RATING = COALESCE(:engineer_rating_string, ENGINEER_RATING);
      """, nativeQuery = true)
  Optional<List<GrowthTrait>> findByTraitTypeOrStatusOrMenteeRatingOrMentorRatingOrEngineerRating(String type,
      String status_state, String mentee_rating_string, String mentor_rating_string, String engineer_rating_string);
}
