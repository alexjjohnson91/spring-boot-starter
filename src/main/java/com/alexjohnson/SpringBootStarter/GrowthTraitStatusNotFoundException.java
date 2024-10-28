package com.alexjohnson.SpringBootStarter;

class GrowthTraitStatusNotFoundException extends RuntimeException {
  GrowthTraitStatusNotFoundException(Status status) {
    super("ERROR: Could not find GrowthTraitStatus " + status);
  }
}
