package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChordBaseTest {
    @Test
    public void AddThirdBasicMajorTest() {
        ChordBase c = new ChordBase(Note.B, Tonality.MAJOR);
        c.addThird();
        assertEquals(Note.D_SHARP, c.notesList.get(1));
    }

    @Test
    public void AddThirdBasicMinorTest() {
        ChordBase chord = new ChordBase(Note.E, Tonality.MINOR);
        chord.addThird();
        assertEquals(Note.G, chord.notesList.get(1));
    }

    @Test
    public void AddThirdSharpRootMajorTest() {
        ChordBase chord = new ChordBase(Note.C_SHARP, Tonality.MAJOR);
        chord.addThird();
        assertEquals(Note.E_SHARP, chord.notesList.get(1));
    }

    @Test
    public void AddThirdSharpRootMinorTest() {
        ChordBase chord = new ChordBase(Note.C_SHARP, Tonality.MINOR);
        chord.addThird();
        assertEquals(Note.E, chord.notesList.get(1));
    }

    @Test
    public void AddThirdProblematicRootTest1() {
        ChordBase chord = new ChordBase(Note.B_SHARP, Tonality.MAJOR);
        chord.addThird();
        assertEquals(Note.D_DOUBLE_SHARP, chord.notesList.get(1));
    }

    @Test
    public void AddThirdProblematicRootTest2() {
        ChordBase chord = new ChordBase(Note.B_SHARP, Tonality.MINOR);
        chord.addThird();
        assertEquals(Note.D_SHARP, chord.notesList.get(1));
    }

    @Test
    public void AddThirdProblematicRootTest3() {
        ChordBase chord = new ChordBase(Note.F_FLAT, Tonality.MINOR);
        chord.addThird();
        assertEquals(Note.A_DOUBLE_FLAT, chord.notesList.get(1));
    }

    @Test
    public void AddThirdProblematicRootTest4() {
        ChordBase chord = new ChordBase(Note.F_FLAT, Tonality.MAJOR);
        chord.addThird();
        assertEquals(Note.A_FLAT, chord.notesList.get(1));
    }

    @Test
    public void AddAllBasicTest() {
        ChordBase chord = new ChordBase(Note.C, Tonality.MAJOR, ScaleType.IONIAN);
        chord.addThird();
        chord.addInterval(Interval.PERFECT_FIFTH);
        chord.addInterval(Interval.MAJOR_SEVENTH);
        chord.addInterval(Interval.MAJOR_SECOND);
        chord.addInterval(Interval.PERFECT_FOURTH);
        chord.addInterval(Interval.MAJOR_SIXTH);

        assertEquals((List.of(Note.C, Note.E, Note.G, Note.B, Note.D, Note.F, Note.A)), chord.notesList);
    }
}
