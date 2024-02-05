package org.example;

/**
 * Represents a musical chord with a root note, tonality, and a specified fifth interval.
 * This class extends the {@code ChordBase} class, inheriting its basic chord structure and functionalities.
 */

public class Chord extends ChordBase {
    protected Interval fifth = Interval.PERFECT_FIFTH;

    /**
     * Constructs a {@code Chord} object with the specified root note and tonality.
     * The fifth interval is added by default.
     *
     * @param rootNote The root note of the chord.
     * @param tonality The tonality of the chord, determining its major or minor quality.
     */
    public Chord(Note rootNote, Tonality tonality) {
        super(rootNote, tonality);
        addFifth();
    }

    /**
     * Adds the fifth interval to the chord. This method can be overridden in subclasses to
     * modify the interval added as the fifth.
     */
    protected void addFifth() {
        addInterval(fifth);
    }
}
