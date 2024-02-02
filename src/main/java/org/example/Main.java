package org.example;

public class Main {
    public static void main(String[] args) {
        /*Note myNote = Note.C_FLAT;
        Note n = Note.C;
        System.out.println(myNote); // Outputs C#
        System.out.println(n);

        ChordBase c = new ChordBase(Note.E_FLAT, Tonality.MINOR, ScaleType.IONIAN);
        System.out.println(c);*/

        ChordBase c = new ChordBase(Note.B, Tonality.MAJOR, ScaleType.IONIAN);
        c.addThird();
        System.out.println(c);

        ChordBase chord1 = new ChordBase(Note.B, Tonality.MAJOR, ScaleType.IONIAN);
        chord1.addThird();
        System.out.println("Chord 1: " + chord1);
        System.out.println(chord1.listAllNotes());

        // Test case 2
        ChordBase chord2 = new ChordBase(Note.E, Tonality.MINOR, ScaleType.AEOLIAN);
        chord2.addThird();
        System.out.println("Chord 2: " + chord2);
        System.out.println(chord2.listAllNotes());

        // Test case 3
        ChordBase chord3 = new ChordBase(Note.C_SHARP, Tonality.MAJOR, ScaleType.LYDIAN);
        chord3.addThird();
        System.out.println("Chord 3: " + chord3);
        System.out.println(chord3.listAllNotes());

        ChordBase chord4 = new ChordBase(Note.C_SHARP, Tonality.MINOR, ScaleType.LYDIAN);
        chord4.addThird();
        System.out.println("Chord 4: " + chord4);
        System.out.println(chord4.listAllNotes());

        // okrajove
        ChordBase chord5 = new ChordBase(Note.B_SHARP, Tonality.MAJOR, ScaleType.LYDIAN);
        chord5.addThird();
        System.out.println("Chord 5: " + chord5);
        System.out.println(chord5.listAllNotes());

        ChordBase chord6 = new ChordBase(Note.B_SHARP, Tonality.MINOR, ScaleType.LYDIAN);
        chord6.addThird();
        System.out.println("Chord 6: " + chord6);
        System.out.println(chord6.listAllNotes());

        ChordBase chord7 = new ChordBase(Note.F_FLAT, Tonality.MINOR, ScaleType.LYDIAN);
        chord7.addThird();
        System.out.println("Chord 7: " + chord7);
        System.out.println(chord7.listAllNotes());

        ChordBase chord8 = new ChordBase(Note.F_FLAT, Tonality.MAJOR, ScaleType.LYDIAN);
        chord8.addThird();
        System.out.println("Chord 8: " + chord8);
        System.out.println(chord8.listAllNotes());

        //zkouska vsech intervalu
        ChordBase chord9 = new ChordBase(Note.C, Tonality.MAJOR, ScaleType.IONIAN);
        chord9.addThird();
        chord9.addInterval(Interval.PERFECT_FIFTH);
        chord9.addInterval(Interval.MAJOR_SEVENTH);
        chord9.addInterval(Interval.MAJOR_SECOND);
        chord9.addInterval(Interval.PERFECT_FOURTH);
        chord9.addInterval(Interval.MAJOR_SIXTH);
        System.out.println("Chord 9: " + chord9);
        System.out.println(chord9.listAllNotes());

        // testing all types
        Scale scale1 = new Scale(Note.C, ScaleType.IONIAN);
        scale1.addNotes();
        System.out.println("Scale:" + scale1.notesList);

        Scale scale2 = new Scale(Note.C, ScaleType.DORIAN);
        scale2.addNotes();
        System.out.println("Scale:" + scale2.notesList);

        Scale scale3 = new Scale(Note.C, ScaleType.PHRYGIAN);
        scale3.addNotes();
        System.out.println("Scale:" + scale3.notesList);

        Scale scale4 = new Scale(Note.C, ScaleType.LYDIAN);
        scale4.addNotes();
        System.out.println("Scale:" + scale4.notesList);

        Scale scale5 = new Scale(Note.C, ScaleType.MIXOLYDIAN);
        scale5.addNotes();
        System.out.println("Scale:" + scale5.notesList);

        Scale scale6 = new Scale(Note.C, ScaleType.AEOLIAN);
        scale6.addNotes();
        System.out.println("Scale:" + scale6.notesList);

        Scale scale7 = new Scale(Note.C, ScaleType.LOCRIAN);
        scale7.addNotes();
        System.out.println("Scale:" + scale7.notesList);

    }
}