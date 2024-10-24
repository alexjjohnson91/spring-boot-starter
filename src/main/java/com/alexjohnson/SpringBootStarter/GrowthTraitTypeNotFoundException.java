package com.alexjohnson.SpringBootStarter;

class GrowthTraitTypeNotFoundException extends RuntimeException {
  GrowthTraitTypeNotFoundException(String type) {
    super("ERROR: Could not find GrowthTraitType " + type);
  }
}
