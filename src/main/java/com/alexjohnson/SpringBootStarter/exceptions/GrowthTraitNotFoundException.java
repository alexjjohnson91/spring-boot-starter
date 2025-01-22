package com.alexjohnson.SpringBootStarter.exceptions;

public class GrowthTraitNotFoundException extends RuntimeException {
    public GrowthTraitNotFoundException() {
        super("ERROR: Could not find GrowthTraitId");
    }
}
