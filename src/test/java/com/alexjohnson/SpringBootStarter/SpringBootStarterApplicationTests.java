package com.alexjohnson.SpringBootStarter;

import static org.assertj.core.api.Assertions.assertThat;

import com.alexjohnson.SpringBootStarter.controllers.GrowthTraitController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootStarterApplicationTests {

    @Autowired
    private GrowthTraitController growthTraitController;

    @Test
    void contextLoads() throws Exception {
        assertThat(growthTraitController).isNotNull();
    }
}
