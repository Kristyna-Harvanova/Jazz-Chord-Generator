package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChordSeventhTest {
    @Test
    public void MakeChordBasicMajorTest() {
        ChordSeventh chord = new ChordSeventh(Note.B, Tonality.MAJOR, Interval.MAJOR_SEVENTH);
        assertEquals(List.of(Note.B, Note.D_SHARP, Note.F_SHARP, Note.A_SHARP), chord.notesList);
    }

    @Test
    public void MakeChordBasicMinorTest() {
        ChordSeventh chord = new ChordSeventh(Note.E, Tonality.MINOR, Interval.MAJOR_SEVENTH);
        assertEquals(List.of(Note.E, Note.G, Note.B, Note.D_SHARP), chord.notesList);
    }

    @Test
    public void MakeChordSharpRootMajorTest() {
        ChordSeventh chord = new ChordSeventh(Note.C_SHARP, Tonality.MAJOR, Interval.MINOR_SEVENTH);
        assertEquals(List.of(Note.C_SHARP, Note.E_SHARP, Note.G_SHARP, Note.B), chord.notesList);
    }

    @Test
    public void MakeChordSharpRootMinorTest() {
        ChordSeventh chord = new ChordSeventh(Note.C_SHARP, Tonality.MINOR, Interval.MINOR_SEVENTH);
        assertEquals(List.of(Note.C_SHARP, Note.E, Note.G_SHARP, Note.B), chord.notesList);
    }

    @Test
    public void MakeChordProblematicRootTest1() {
        ChordSeventh chord = new ChordSeventh(Note.B_SHARP, Tonality.MAJOR, Interval.MAJOR_SEVENTH);
        assertEquals(List.of(Note.B_SHARP, Note.D_DOUBLE_SHARP, Note.F_DOUBLE_SHARP, Note.A_DOUBLE_SHARP), chord.notesList);
    }

    @Test
    public void MakeChordProblematicRootTest2() {
        ChordSeventh chord = new ChordSeventh(Note.B_SHARP, Tonality.MINOR, Interval.MAJOR_SEVENTH);
        assertEquals(List.of(Note.B_SHARP, Note.D_SHARP, Note.F_DOUBLE_SHARP, Note.A_DOUBLE_SHARP), chord.notesList);
    }

    @Test
    public void MakeChordProblematicRootTest3() {
        ChordSeventh chord = new ChordSeventh(Note.F_FLAT, Tonality.MINOR, Interval.MINOR_SEVENTH);
        assertEquals(List.of(Note.F_FLAT, Note.A_DOUBLE_FLAT, Note.C_FLAT, Note.E_DOUBLE_FLAT), chord.notesList);
    }

    @Test
    public void MakeChordProblematicRootTest4() {
        ChordSeventh chord = new ChordSeventh(Note.F_FLAT, Tonality.MAJOR, Interval.MINOR_SEVENTH);
        assertEquals(List.of(Note.F_FLAT, Note.A_FLAT, Note.C_FLAT, Note.E_DOUBLE_FLAT), chord.notesList);
    }

    @Test
    public void ToStringBasicMajorTest() {
        ChordSeventh chord = new ChordSeventh(Note.B, Tonality.MAJOR, Interval.MAJOR_SEVENTH);
        assertEquals("B△", chord.toString());
    }

    @Test
    public void ToStringBasicMinorTest() {
        ChordSeventh chord = new ChordSeventh(Note.E, Tonality.MINOR, Interval.MAJOR_SEVENTH);
        assertEquals("E-△", chord.toString());
    }

    @Test
    public void ToStringSharpRootMajorTest() {
        ChordSeventh chord = new ChordSeventh(Note.C_SHARP, Tonality.MAJOR, Interval.MINOR_SEVENTH);
        assertEquals("C#7", chord.toString());
    }

    @Test
    public void ToStringSharpRootMinorTest() {
        ChordSeventh chord = new ChordSeventh(Note.C_SHARP, Tonality.MINOR, Interval.MINOR_SEVENTH);
        assertEquals("C#-7", chord.toString());
    }

    @Test
    public void ToStringProblematicRootTest1() {
        ChordSeventh chord = new ChordSeventh(Note.B_SHARP, Tonality.MAJOR, Interval.MAJOR_SEVENTH);
        assertEquals("B#△", chord.toString());
    }

    @Test
    public void ToStringProblematicRootTest2() {
        ChordSeventh chord = new ChordSeventh(Note.B_SHARP, Tonality.MINOR, Interval.MAJOR_SEVENTH);
        assertEquals("B#-△", chord.toString());
    }

    @Test
    public void ToStringProblematicRootTest3() {
        ChordSeventh chord = new ChordSeventh(Note.F_FLAT, Tonality.MINOR, Interval.MINOR_SEVENTH);
        assertEquals("Fb-7", chord.toString());
    }

    @Test
    public void ToStringProblematicRootTest4() {
        ChordSeventh chord = new ChordSeventh(Note.F_FLAT, Tonality.MAJOR, Interval.MINOR_SEVENTH);
        assertEquals("Fb7", chord.toString());
    }
}
