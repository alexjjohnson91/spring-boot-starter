package com.alexjohnson.SpringBootStarter;

class GrowthTraitIdNotFoundException extends RuntimeException {
  GrowthTraitIdNotFoundException(Long id) {
    super("ERROR: Could not find GrowthTraitId " + id);
  }
}
