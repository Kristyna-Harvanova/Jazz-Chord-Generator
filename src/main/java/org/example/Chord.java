package org.example;

public class Chord extends ChordBase {
    protected Interval fifth = Interval.PERFECT_FIFTH;
    public Chord(Note rootNote, Tonality tonality) {
        super(rootNote, tonality);
        addFifth();
    }

    protected void addFifth() {
        addInterval(fifth);
    }
}
