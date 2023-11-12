package org.example;

public enum Tonality {
    MAJOR, MINOR;

    @Override
    public String toString() {
        return switch (this) {
            case MAJOR -> "";
            case MINOR -> "-";
        };
    }
}