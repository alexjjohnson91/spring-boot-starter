package com.alexjohnson.SpringBootStarter;

import com.alexjohnson.SpringBootStarter.types.Status;

class GrowthTraitStatusNotFoundException extends RuntimeException {
  GrowthTraitStatusNotFoundException(Status status) {
    super("ERROR: Could not find GrowthTraitStatus " + status);
  }
}
