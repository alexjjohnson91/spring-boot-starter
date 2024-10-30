package com.alexjohnson.SpringBootStarter;

class GrowthTraitNotFoundException extends RuntimeException {
  GrowthTraitNotFoundException() {
    super("ERROR: Could not find GrowthTraitId");
  }
}
