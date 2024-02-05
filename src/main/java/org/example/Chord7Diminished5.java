package org.example;

import java.util.EnumSet;

/**
 * Represents a 7th chord with a diminished fifth interval, extending the basic chord structure from {@code ChordBase}.
 * This chord class specifically handles chords with a root note, a diminished fifth, and a seventh interval that can either be minor or diminished.
 */

public class Chord7Diminished5 extends ChordBase {
    protected Interval fifth = Interval.TRITONE_DIM5;
    protected Interval seventh;

    /**
     * Defines the allowed seventh intervals for this chord type, which include minor seventh and diminished seventh.
     */
    private static final EnumSet<Interval> ALLOWED_SEVENTHS = EnumSet.of(Interval.MINOR_SEVENTH, Interval.DIMINISHED_SEVENTH);

    /**
     * Constructs a {@code Chord7Diminished5} object with the specified root note and seventh interval.
     * Validates the seventh interval to ensure it is either a minor seventh or a diminished seventh.
     *
     * @param rootNote The root note of the chord.
     * @param seventh The seventh interval of the chord, must be either {@code Interval.MINOR_SEVENTH} or {@code Interval.DIMINISHED_SEVENTH}.
     * @throws IllegalArgumentException If the provided seventh interval is not allowed.
     */
    public Chord7Diminished5(Note rootNote, Interval seventh) {
        super(rootNote, Tonality.MINOR);

        if (!ALLOWED_SEVENTHS.contains(seventh)) {
            throw new IllegalArgumentException("Invalid seventh interval: " + seventh + ". Allowed intervals are MINOR_SEVENTH and DIMINISHED_SEVENTH.");
        }

        this.seventh = seventh;
        addFifth();
        addSeventh();
    }

    /**
     * Adds the fifth interval to the chord, specifically a diminished fifth in this case.
     */
    protected void addFifth() { addInterval(fifth); }

    /**
     * Adds the specified seventh interval to the chord.
     */
    protected void addSeventh() { addInterval(seventh); }

    /**
     * Returns a string representation of the chord, showing the root note followed by a chord symbol indicating its diminished status.
     *
     * @return A string representation of the chord.
     */
    @Override
    public String toString() {
        return rootNote.toString() + ((seventh == Interval.DIMINISHED_SEVENTH) ? "°" : "-7b5");
    }
}
