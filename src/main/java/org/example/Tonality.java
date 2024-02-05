package org.example;

/**
 * Enumerates the two basic tonalities in music: MAJOR and MINOR.
 * This enum is used to represent the tonality of chords, scales, and musical pieces,
 * distinguishing between major and minor keys.
 */
public enum Tonality {
    /**
     * Represents the major tonality, often associated with a happy or bright sound.
     */
    MAJOR,

    /**
     * Represents the minor tonality, often associated with a sad or melancholic sound.
     */
    MINOR;

    /**
     * Provides a custom string representation of the tonality.
     * Major tonality is represented by an empty string, and minor tonality by a "-" sign.
     *
     * @return A string representation of the tonality, customized for display purposes.
     */
    @Override
    public String toString() {
        return switch (this) {
            case MAJOR -> "";
            case MINOR -> "-";
        };
    }
}