package org.example;

public class Chord7Diminished5 extends ChordBase {
    protected Interval fifth = Interval.TRITONE_DIM5;
    protected Interval seventh; //TODO: omezit, aby nemohlo byt MAJOR_SEVENTH

    public Chord7Diminished5(Note rootNote, Interval seventh) {
        super(rootNote, Tonality.MINOR);
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
