package org.example;

import java.util.EnumSet;

public class ChordSeventh extends Chord {
    protected Interval seventh;
    private static final EnumSet<Interval> ALLOWED_SEVENTHS = EnumSet.of(Interval.MAJOR_SEVENTH, Interval.MINOR_SEVENTH);

    public ChordSeventh(Note rootNote, Tonality tonality, Interval seventh) {
        super(rootNote, tonality);

        if (!ALLOWED_SEVENTHS.contains(seventh)) {
            throw new IllegalArgumentException("Invalid seventh interval: " + seventh + ". Allowed intervals are MAJOR_SEVENTH and MINOR_SEVENTH.");
        }

        this.seventh = seventh;
        addSeventh();
    }

    protected void addSeventh() {
        addInterval(seventh);
    }

    @Override
    public String toString() {
        return super.toString() + ((seventh == Interval.MAJOR_SEVENTH) ? "△" : "7");
    }
}
