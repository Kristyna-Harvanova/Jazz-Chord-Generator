package org.example;

public enum Interval {
    UNISON(0, 0),
    MINOR_SECOND(1, -5),
    MAJOR_SECOND(2, 2),
    MINOR_THIRD(3, -3),
    MAJOR_THIRD(4, 4),
    PERFECT_FOURTH(5, -1),
    TRITONE_AUG4(6, 6), // Also known as augmented fourth or diminished fifth // TODO: or +6... do i need triton in usage? meybe in dim? +6 Fis or -6 Ges... i need for scales
    TRITONE_DIM5(6, -6),
    PERFECT_FIFTH(7, 1),
    MINOR_SIXTH(8, -4),
    MAJOR_SIXTH(9, 3),
    MINOR_SEVENTH(10, -2),
    MAJOR_SEVENTH(11, 5),
    OCTAVE(12, 0);

    private final int semitones;
    private int shiftOn45Circle;

    Interval(int semitones, int shiftOn45Circle) {
        this.semitones = semitones;
        this.shiftOn45Circle = shiftOn45Circle;
    }

    public int getSemitones() {
        return semitones;
    }

    public int getShift() { return shiftOn45Circle; }

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
