package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllChordsTest {
    @Test
    public void ConstructorChordTest1() {
        Chord chord = new Chord(Note.C, Tonality.MAJOR);
        assertEquals(List.of(Note.C, Note.E, Note.G), chord.notesList);
    }

    @Test
    public void ToStringChordTest1() {
        Chord chord = new Chord(Note.C, Tonality.MAJOR);
        assertEquals("C", chord.toString());
    }

    @Test
    public void ConstructorChordTest2() {
        Chord chord = new Chord(Note.C, Tonality.MINOR);
        assertEquals(List.of(Note.C, Note.E_FLAT, Note.G), chord.notesList);
    }

    @Test
    public void ToStringChordTest2() {
        Chord chord = new Chord(Note.C, Tonality.MINOR);
        assertEquals("C-", chord.toString());
    }

    @Test
    public void ConstructorChordAugmented5Test() {
        ChordAugmented5 chord = new ChordAugmented5(Note.C);
        assertEquals(List.of(Note.C, Note.E, Note.G_SHARP), chord.notesList);
    }

    @Test
    public void ToStringChordAugmented5Test() {
        ChordAugmented5 chord = new ChordAugmented5(Note.C);
        assertEquals("C+", chord.toString());
    }

    @Test
    public void ConstructorChordSeventhTest1() {
        ChordSeventh chord = new ChordSeventh(Note.C, Tonality.MAJOR, Interval.MAJOR_SEVENTH);
        assertEquals(List.of(Note.C, Note.E, Note.G, Note.B), chord.notesList);
    }

    @Test
    public void ToStringChordSeventhTest1() {
        ChordSeventh chord = new ChordSeventh(Note.C, Tonality.MAJOR, Interval.MAJOR_SEVENTH);
        assertEquals("C△", chord.toString());
    }

    @Test
    public void ConstructorChordSeventhTest2() {
        ChordSeventh chord = new ChordSeventh(Note.C, Tonality.MAJOR, Interval.MINOR_SEVENTH);
        assertEquals(List.of(Note.C, Note.E, Note.G, Note.B_FLAT), chord.notesList);
    }

    @Test
    public void ToStringChordSeventhTest2() {
        ChordSeventh chord = new ChordSeventh(Note.C, Tonality.MAJOR, Interval.MINOR_SEVENTH);
        assertEquals("C7", chord.toString());
    }

    @Test
    public void ConstructorChordSeventhTest3() {
        ChordSeventh chord = new ChordSeventh(Note.C, Tonality.MINOR, Interval.MAJOR_SEVENTH);
        assertEquals(List.of(Note.C, Note.E_FLAT, Note.G, Note.B), chord.notesList);
    }

    @Test
    public void ToStringChordSeventhTest3() {
        ChordSeventh chord = new ChordSeventh(Note.C, Tonality.MINOR, Interval.MAJOR_SEVENTH);
        assertEquals("C-△", chord.toString());
    }

    @Test
    public void ConstructorChordSeventhTest4() {
        ChordSeventh chord = new ChordSeventh(Note.C, Tonality.MINOR, Interval.MINOR_SEVENTH);
        assertEquals(List.of(Note.C, Note.E_FLAT, Note.G, Note.B_FLAT), chord.notesList);
    }

    @Test
    public void ToStringChordSeventhTest4() {
        ChordSeventh chord = new ChordSeventh(Note.C, Tonality.MINOR, Interval.MINOR_SEVENTH);
        assertEquals("C-7", chord.toString());
    }

    @Test
    public void ConstructorChord7Diminished5Test1() {
        Chord7Diminished5 chord = new Chord7Diminished5(Note.C, Interval.MINOR_SEVENTH);
        assertEquals(List.of(Note.C, Note.E_FLAT, Note.G_FLAT, Note.B_FLAT), chord.notesList);
    }

    @Test
    public void ToStringChord7Diminished5Test1() {
        Chord7Diminished5 chord = new Chord7Diminished5(Note.C, Interval.MINOR_SEVENTH);
        assertEquals("C-7b5", chord.toString());
    }

    @Test
    public void ConstructorChord7Diminished5Test2() {
        Chord7Diminished5 chord = new Chord7Diminished5(Note.C, Interval.DIMINISHED_SEVENTH);
        assertEquals(List.of(Note.C, Note.E_FLAT, Note.G_FLAT, Note.B_DOUBLE_FLAT), chord.notesList);
    }

    @Test
    public void ToStringChord7Diminished5Test2() {
        Chord7Diminished5 chord = new Chord7Diminished5(Note.C, Interval.DIMINISHED_SEVENTH);
        assertEquals("C°", chord.toString());
    }
}
