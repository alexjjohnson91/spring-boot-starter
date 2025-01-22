package com.alexjohnson.SpringBootStarter.repositories;

import com.alexjohnson.SpringBootStarter.dtos.GrowthTrait;
import com.alexjohnson.SpringBootStarter.dtos.interfaces.GrowthPlanTrait;
import com.alexjohnson.SpringBootStarter.dtos.interfaces.GrowthTraitData;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface GrowthTraitRepository extends Repository<GrowthTrait, Long> {

    Optional<GrowthTrait> findById(Long id);

    @Query(
            value =
                    """
        SELECT
          A.GROWTH_ASSESSMENT_ID,
          B.GROWTH_TRAIT_ID,
          A.DETAIL,
          A.TRAIT_TYPE,
          A.MENTEE_RATING,
          A.MENTOR_RATING,
          A.ENGINEER_RATING,
          B.STATUS
        FROM GROWTH_ASSESSMENT A
        JOIN GROWTH_TRAIT B ON A.GROWTH_ASSESSMENT_ID = B.GROWTH_ASSESSMENT_ID;
      """,
            nativeQuery = true)
    List<GrowthPlanTrait> findAll();

    @Query(
            value =
                    """
        SELECT
          A.GROWTH_ASSESSMENT_ID,
          B.GROWTH_TRAIT_ID,
          A.DETAIL,
          A.TRAIT_TYPE,
          A.MENTEE_RATING,
          A.MENTOR_RATING,
          A.ENGINEER_RATING,
          B.STATUS
        FROM GROWTH_ASSESSMENT A
        JOIN GROWTH_TRAIT B ON A.GROWTH_ASSESSMENT_ID = B.GROWTH_ASSESSMENT_ID
        WHERE
          A.TRAIT_TYPE = COALESCE(:type, TRAIT_TYPE) AND
          B.STATUS = COALESCE(:status_state, STATUS) AND
          A.MENTEE_RATING = COALESCE(:mentee_rating_string, MENTEE_RATING) AND
          A.MENTOR_RATING = COALESCE(:mentor_rating_string, MENTOR_RATING) AND
          A.ENGINEER_RATING = COALESCE(:engineer_rating_string, ENGINEER_RATING);
      """,
            nativeQuery = true)
    List<GrowthPlanTrait> findByTraitTypeOrStatusOrMenteeRatingOrMentorRatingOrEngineerRating(
            @Param("type") String type,
            @Param("status_state") String status_state,
            @Param("mentee_rating_string") String mentee_rating_string,
            @Param("mentor_rating_string") String mentor_rating_string,
            @Param("engineer_rating_string") String engineer_rating_string);

    @Query(
            value =
                    """
            SELECT
              B.DETAIL,
              B.TRAIT_TYPE,
              A.RESULT,
              A.OPPORTUNITY,
              A.NEXT_STEP,
              A.GOAL,
              A.START_DATE,
              A.STATUS,
              A.AGE,
              A.NOTES
            FROM GROWTH_TRAIT A
            JOIN GROWTH_ASSESSMENT B
              ON A.GROWTH_ASSESSMENT_ID = B.GROWTH_ASSESSMENT_ID
            WHERE
              A.GROWTH_TRAIT_ID = :id;
      """,
            nativeQuery = true)
    GrowthTraitData findByGrowthTraitId(Long id);

    GrowthTrait save(GrowthTrait growthTrait);
}
