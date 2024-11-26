package com.alexjohnson.SpringBootStarter.enums;

public enum TraitRate {
    UNPRACTICED,
    EMERGING,
    PRACTICING,
    CONSISTENT,
    RADIATING;

    public TraitRate next() {
        int nextInt = (this.ordinal() + 1) % TraitRate.values().length;
        return TraitRate.values()[nextInt];
    }
}
