package org.example;

/**
 * Enumerates musical intervals, each defined by a specific number of semitones and a corresponding shift on the circle of fifths.
 * This enum includes common intervals ranging from unison to an octave, and special intervals like the tritone.
 */
public enum Interval {
    UNISON(0, 0),
    MINOR_SECOND(1, -5),
    MAJOR_SECOND(2, 2),
    MINOR_THIRD(3, -3),
    MAJOR_THIRD(4, 4),
    PERFECT_FOURTH(5, -1),
    TRITONE_AUG4(6, 6), // Also known as augmented fourth or diminished fifth
    TRITONE_DIM5(6, -6),
    PERFECT_FIFTH(7, 1),
    MINOR_SIXTH(8, -4),
    AUGMENTED_FIFTH(8, 8), // Special interval needs to be written after basic one in order to have lower priority
    MAJOR_SIXTH(9, 3),
    DIMINISHED_SEVENTH(9, -9),
    MINOR_SEVENTH(10, -2),
    MAJOR_SEVENTH(11, 5),
    OCTAVE(12, 0);

    private final int semitones;
    private final int shiftOn45Circle;

    /**
     * Constructs an {@code Interval} enum constant with the specified number of semitones and shift on the circle of fifths.
     *
     * @param semitones The number of semitones between the two notes of the interval.
     * @param shiftOn45Circle The shift on the circle of fifths corresponding to the interval.
     */
    Interval(int semitones, int shiftOn45Circle) {
        this.semitones = semitones;
        this.shiftOn45Circle = shiftOn45Circle;
    }

    /**
     * Returns the number of semitones for the interval.
     *
     * @return The number of semitones.
     */
    public int getSemitones() {
        return semitones;
    }

    /**
     * Returns the shift on the circle of fifths for the interval.
     *
     * @return The shift on the circle of fifths.
     */
    public int getShift() { return shiftOn45Circle; }

    /**
     * Returns the {@code Interval} corresponding to a given number of semitones.
     *
     * @param semitones The number of semitones to find the corresponding interval.
     * @return The {@code Interval} corresponding to the specified number of semitones, or {@code null} if no match is found.
     */
    public static Interval fromSemitones(int semitones) {
        for (Interval interval : Interval.values()) {
            if (interval.semitones == semitones) {
                return interval;
            }
        }
        // Handle the case where no match is found
        throw new IllegalArgumentException("No interval for " + semitones + " semitones");
    }

    @Override
    public String toString() {
        return this.name() + " (" + semitones + " semitones)";
    }
}
