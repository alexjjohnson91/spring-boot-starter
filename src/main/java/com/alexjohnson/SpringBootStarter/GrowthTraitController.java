package com.alexjohnson.SpringBootStarter;

import com.alexjohnson.SpringBootStarter.enums.Status;
import com.alexjohnson.SpringBootStarter.enums.TraitRate;
import com.alexjohnson.SpringBootStarter.enums.TraitType;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class GrowthTraitController {
    private final GrowthTraitService growthTraitService;

    @PostMapping(path = "/growth-traits/save-all")
    void saveAll() {
        growthTraitService.saveAllGrowthTraits();
    }

    @GetMapping(path = "/growth-traits/{id}")
    GrowthTraitData getByGrowthTraitId(@PathVariable Long id) {
        return growthTraitService.getByGrowthTraitId(id);
    }

    @GetMapping(path = "/growth-traits")
    List<GrowthPlanTrait> getGrowthTraitsByRatings(
            @RequestParam(name = "trait_type", required = false) TraitType trait_type,
            @RequestParam(name = "status", required = false) Status status,
            @RequestParam(name = "mentee_rating", required = false) TraitRate mentee_rating,
            @RequestParam(name = "mentor_rating", required = false) TraitRate mentor_rating,
            @RequestParam(name = "engineer_rating", required = false) TraitRate engineer_rating) {
        return growthTraitService.findByGrowthTraitParameters(
                trait_type != null ? trait_type.toString() : null,
                status != null ? status.toString() : null,
                mentee_rating != null ? mentee_rating.toString() : null,
                mentor_rating != null ? mentor_rating.toString() : null,
                engineer_rating != null ? engineer_rating.toString() : null);
    }

    @PatchMapping(path = "/growth-traits/{id}/next-status")
    GrowthTrait moveTraitToNextStatus(@PathVariable Long id) {
        return growthTraitService.moveTraitToNextStatus(id);
    }

    @PatchMapping(path = "/growth-traits/{id}/prev-status")
    GrowthTrait moveTraitToPrevStatus(@PathVariable Long id) {
        return growthTraitService.moveTraitToPrevStatus(id);
    }
}
