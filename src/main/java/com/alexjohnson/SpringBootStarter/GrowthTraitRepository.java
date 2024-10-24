package com.alexjohnson.SpringBootStarter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GrowthTraitRepository
    extends JpaRepository<GrowthTrait, Long> {}
