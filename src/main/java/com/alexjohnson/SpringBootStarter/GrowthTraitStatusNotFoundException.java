package com.alexjohnson.SpringBootStarter;

class GrowthTraitStatusNotFoundException extends RuntimeException {
  GrowthTraitStatusNotFoundException(String status) {
    super("ERROR: Could not find GrowthTraitStatus " + status);
  }
}
