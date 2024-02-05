package org.example;

/**
 * Represents a chord with an augmented fifth interval, extending the basic chord structure from {@code ChordBase}.
 * This chord type specifically features a major tonality with an augmented fifth added to the base chord structure.
 */
public class ChordAugmented5 extends ChordBase {
    protected Interval fifth = Interval.AUGMENTED_FIFTH;

    /**
     * Constructs a {@code ChordAugmented5} object with the specified root note.
     * The chord is initialized with a major tonality and an augmented fifth is added to it.
     *
     * @param rootNote The root note of the chord.
     */
    public ChordAugmented5(Note rootNote) {
        super(rootNote, Tonality.MAJOR);
        addFifth();
    }

    /**
     * Adds the fifth interval to the chord, specifically an augmented fifth in this case.
     */
    protected void addFifth() {
        addInterval(fifth);
    }

    /**
     * Returns a string representation of the chord, appending a "+" to indicate the augmented fifth.
     *
     * @return A string representation of the chord with an indication of the augmented fifth.
     */
    @Override
    public String toString() {
        return super.toString() + "+";
    }
}
