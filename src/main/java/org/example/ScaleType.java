package org.example;

/**
 * Enumerates types of musical scales.
 * Each scale type is defined by a unique sequence of intervals starting from the root note.
 */
public enum ScaleType {
    IONIAN(0),
    DORIAN(1),
    PHRYGIAN(2),
    LYDIAN(3),
    MIXOLYDIAN(4),
    AEOLIAN(5),
    LOCRIAN(6);

    /**
     * The intervals between consecutive notes in the scale, starting from the root note.
     */
    private final Interval[] intervalsInBetween;

    /**
     * Constructs a {@code ScaleType} with a specified rotation of the major scale intervals.
     * This rotation determines the unique sequence of intervals that define the scale type.
     *
     * @param rotation The rotation of the major scale intervals to create this scale type.
     */
    ScaleType(int rotation) {
        Interval[] MAJOR_SCALE = {
                Interval.MAJOR_SECOND,
                Interval.MAJOR_SECOND,
                Interval.MINOR_SECOND,
                Interval.MAJOR_SECOND,
                Interval.MAJOR_SECOND,
                Interval.MAJOR_SECOND,
                Interval.MINOR_SECOND
        };
        this.intervalsInBetween = rotateIntervals(MAJOR_SCALE, rotation);
    }

    /**
     * Rotates the given array of intervals by a specified amount to create the interval sequence for particular scale type.
     *
     * @param intervals The array of intervals to be rotated.
     * @param rotation The number of positions by which to rotate the array.
     * @return An array of {@code Interval} objects representing the rotated intervals.
     */
    private static Interval[] rotateIntervals(Interval[] intervals, int rotation) {
        Interval[] rotated = new Interval[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            rotated[i] = intervals[(i + rotation) % intervals.length];
        }
        return rotated;
    }

    /**
     * Returns the intervals between consecutive notes in this scale type, starting from the root note.
     *
     * @return An array of {@code Interval} objects representing the intervals from the root note.
     */
    public Interval[] getIntervalsFromRoot() {
        Interval[] result = new Interval[7];
        int semitonesFromRoot = 0;
        int i = 0;
        for (Interval interval : intervalsInBetween) {
            semitonesFromRoot += interval.getSemitones();

            if (semitonesFromRoot == Interval.TRITONE_AUG4.getSemitones() && i == 2) {
                result[i++] = Interval.TRITONE_AUG4;
                continue;
            } else if (semitonesFromRoot == Interval.TRITONE_DIM5.getSemitones() && i == 3) {
                result[i++] = Interval.TRITONE_DIM5;
                continue;
            }
            result[i++] = Interval.fromSemitones(semitonesFromRoot);
        }
        return result;
    }

    /**
     * Converts a string representation of a scale type into the corresponding {@code ScaleType} enum constant.
     * This method allows for flexible input, including varying cases, to match the string representation to an enum constant.
     *
     * @param typeStr The string representation of the scale type, such as "Ionian", "Dorian", etc.
     * @return The corresponding {@code ScaleType} enum constant, or {@code null} if no matching constant is found.
     * @throws IllegalArgumentException If {@code typeStr} is null or empty, indicating an invalid or unspecified scale type.
     */
    public static ScaleType fromString(String typeStr) {
        if (typeStr == null || typeStr.isEmpty()) {
            throw new IllegalArgumentException("ScaleType string cannot be null or empty.");
        }

        String formattedTypeStr = typeStr.toUpperCase();

        try {
            return ScaleType.valueOf(formattedTypeStr);
        } catch (IllegalArgumentException e) {
            //throw new IllegalArgumentException("No corresponding ScaleType enum constant for: " + typeStr);
            return null;
        }
    }
}

