package org.example;

import java.util.EnumSet;

public class Chord7Diminished5 extends ChordBase {
    protected Interval fifth = Interval.TRITONE_DIM5;
    protected Interval seventh;
    private static final EnumSet<Interval> ALLOWED_SEVENTHS = EnumSet.of(Interval.MINOR_SEVENTH, Interval.DIMINISHED_SEVENTH);


    public Chord7Diminished5(Note rootNote, Interval seventh) {
        super(rootNote, Tonality.MINOR);

        if (!ALLOWED_SEVENTHS.contains(seventh)) {
            throw new IllegalArgumentException("Invalid seventh interval: " + seventh + ". Allowed intervals are MINOR_SEVENTH and DIMINISHED_SEVENTH.");
        }

        this.seventh = seventh;
        addFifth();
        addSeventh();
    }

    protected void addFifth() { addInterval(fifth); }

    protected void addSeventh() { addInterval(seventh); }

    @Override
    public String toString() {
        return rootNote.toString() + ((seventh == Interval.DIMINISHED_SEVENTH) ? "°" : "-7b5");
    }
}
