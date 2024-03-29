package com.pathfinder.pathfinder.model.enums;

public enum ObjectType {

    EMPTY(0), START_POINT(1), END_POINT(2), OBSTACLE(3);

    public final int value;

    ObjectType(int value) {
        this.value = value;
    }

}
