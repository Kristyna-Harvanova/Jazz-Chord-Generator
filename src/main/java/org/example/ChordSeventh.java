package org.example;

import java.util.EnumSet;

/**
 * Represents a seventh chord, extending the {@code Chord} class. This class specifically handles
 * chords that include a seventh interval, either major or minor, in addition to the root note and tonality.
 */
public class ChordSeventh extends Chord {
    protected Interval seventh;

    /**
     * Defines the allowed seventh intervals for this chord type, which include major seventh and minor seventh.
     */
    private static final EnumSet<Interval> ALLOWED_SEVENTHS = EnumSet.of(Interval.MAJOR_SEVENTH, Interval.MINOR_SEVENTH);

    /**
     * Constructs a {@code ChordSeventh} object with the specified root note, tonality, and seventh interval.
     * Validates the seventh interval to ensure it is either a major seventh or a minor seventh.
     *
     * @param rootNote The root note of the chord.
     * @param tonality The tonality of the chord, determining its major or minor quality.
     * @param seventh The seventh interval of the chord, must be either {@code Interval.MAJOR_SEVENTH} or {@code Interval.MINOR_SEVENTH}.
     * @throws IllegalArgumentException If the provided seventh interval is not allowed.
     */
    public ChordSeventh(Note rootNote, Tonality tonality, Interval seventh) {
        super(rootNote, tonality);

        if (!ALLOWED_SEVENTHS.contains(seventh)) {
            throw new IllegalArgumentException("Invalid seventh interval: " + seventh + ". Allowed intervals are MAJOR_SEVENTH and MINOR_SEVENTH.");
        }

        this.seventh = seventh;
        addSeventh();
    }

    /**
     * Adds the specified seventh interval to the chord.
     */
    protected void addSeventh() {
        addInterval(seventh);
    }

    /**
     * Returns a string representation of the chord, appending a symbol to indicate the type of seventh interval.
     *
     * @return A string representation of the chord, including an indication of the seventh interval.
     */
    @Override
    public String toString() {
        return super.toString() + ((seventh == Interval.MAJOR_SEVENTH) ? "△" : "7");
    }
}
