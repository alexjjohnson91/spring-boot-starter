package com.alexjohnson.SpringBootStarter;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface GrowthAssessmentRepository extends Repository<GrowthAssessment, Long> {
    List<GrowthAssessment> findAll();

    Optional<GrowthAssessment> findById(Long id);

    GrowthAssessment save(GrowthAssessment growthAssessment);
}
