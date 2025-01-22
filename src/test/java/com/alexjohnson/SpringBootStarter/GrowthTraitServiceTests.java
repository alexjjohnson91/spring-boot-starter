package com.alexjohnson.SpringBootStarter;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class GrowthTraitServiceTests {

    @Mock
    private GrowthTraitRepository growthTraitRepository;

    @InjectMocks
    private GrowthTraitService growthTraitService;

    //    GrowthTraitData getByGrowthTraitId(Long id) {
    //        return growthTraitRepository.findByGrowthTraitId(id);
    //    }

    // region getByGrowthTraitId

    @Test
    void getByGrowthTraitId_withValidId_returnsGrowthTrait() {
        // Arrange
        GrowthTraitData expectedGrowthTraitData = new GrowthTraitData();
        when(growthTraitRepository.findByGrowthTraitId(anyLong())).thenReturn(expectedGrowthTraitData);

        // Act
        GrowthTraitData growthTraitData = growthTraitService.getByGrowthTraitId(4L);

        // Assert
        assertThat(growthTraitData).isNotNull();
        assertThat(growthTraitData).isEqualTo(expectedGrowthTraitData);
    }

    // end region getByGrowthTraitId

}
