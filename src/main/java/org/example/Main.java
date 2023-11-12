package org.example;

public class Main {
    public static void main(String[] args) {
        Note myNote = Note.C_FLAT;
        Note n = Note.C;
        System.out.println(myNote); // Outputs C#
        System.out.println(n);

        ChordBase c = new ChordBase(Note.E_FLAT, Tonality.MINOR, ScaleType.IONIAN);
        System.out.println(c);



    }
}