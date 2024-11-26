package com.alexjohnson.SpringBootStarter.enums;

public enum Status {
    NEW,
    PLANNED,
    ACTIVE_FOCUS,
    AUTO_PILOT,
    DEMONSTRATED;

    public Status next() {
        int nextInt = (this.ordinal() + 1) % Status.values().length;
        return Status.values()[nextInt];
    }

    public Status prev() {
        if (this.name() == Status.NEW.toString()) {
            return this;
        }
        return Status.values()[this.ordinal() - 1];
    }
}
