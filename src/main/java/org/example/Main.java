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

        // Test case 2
        ChordBase chord2 = new ChordBase(Note.E, Tonality.MINOR, ScaleType.AEOLIAN);
        chord2.addThird();
        System.out.println("Chord 2: " + chord2);

        // Test case 3
        ChordBase chord3 = new ChordBase(Note.C_SHARP, Tonality.MAJOR, ScaleType.LYDIAN);
        chord3.addThird();
        System.out.println("Chord 3: " + chord3);

        ChordBase chord4 = new ChordBase(Note.C_SHARP, Tonality.MINOR, ScaleType.LYDIAN);
        chord4.addThird();
        System.out.println("Chord 4: " + chord4);



    }
}