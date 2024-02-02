package org.example;

public class ChordSeventh extends Chord {
    protected Interval seventh;
    public ChordSeventh(Note rootNote, Tonality tonality, Interval seventh) {
        super(rootNote, tonality);
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
