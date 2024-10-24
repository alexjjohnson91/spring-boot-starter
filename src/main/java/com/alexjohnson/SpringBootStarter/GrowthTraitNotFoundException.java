package com.alexjohnson.SpringBootStarter;

class GrowthTraitNotFoundException extends RuntimeException {

  GrowthTraitNotFoundException(Long id) {
    super("ERROR: Could not find GrowthTrait " + id);
  }
}
