package org.example;

public class ChordAugmented5 extends ChordBase {
    protected Interval fifth = Interval.AUGMENTED_FIFTH;

    public ChordAugmented5(Note rootNote) {
        super(rootNote, Tonality.MAJOR);
        addFifth();
    }

    protected void addFifth() {
        addInterval(fifth);
    }

    @Override
    public String toString() {
        return super.toString() + "+";
    }
}
