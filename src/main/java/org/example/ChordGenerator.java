package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChordGenerator {
    private static final Random random = new Random();

    public static List<IChord> generateRandomChords(int numberOfChords, int option) {
        List<IChord> chords = new ArrayList<>();
        for (int i = 0; i < numberOfChords; i++) {
            chords.add(generateRandomChordForOption(option));
        }
        return chords;
    }

    public static IChord generateRandomChordForOption(int option) {
        return switch (option) {
            case 1 -> generateRandomChordForOption1();
            case 2 -> generateRandomChordForOption2();
            case 3 -> generateRandomChordForOption3();
            case 4 -> generateRandomChordForOption4();
            case 5 -> generateRandomChordForOption5();
            default -> null;
        };
    }

    private static IChord generateRandomChordForOption1() {
        return createChord();
    }

    private static IChord generateRandomChordForOption2() {
        int choice2 = random.nextInt(2);
        return switch (choice2) {
            case 0 -> createChord();
            case 1 -> createChordAugmented5();
            default -> null;
        };
    }

    private static IChord generateRandomChordForOption3() {
        return createChordSeventh();
    }

    private static IChord generateRandomChordForOption4() {
        int choice4 = random.nextInt(2);
        return switch (choice4) {
            case 0 -> createChordSeventh();
            case 1 -> createChord7Diminished5();
            default -> null;
        };
    }

    private static IChord generateRandomChordForOption5() {
        int choice = random.nextInt(4);

        return switch (choice) {
            case 0 -> createChord();
            case 1 -> createChordAugmented5();
            case 2 -> createChordSeventh();
            case 3 -> createChord7Diminished5();
            default -> null;
        };
    }

    private static Chord createChord() {
        return new Chord(getRandomNote(), getRandomTonality());
    }

    private static ChordAugmented5 createChordAugmented5() {
        return new ChordAugmented5(getRandomNote());
    }

    private static ChordSeventh createChordSeventh() {
        return new ChordSeventh(getRandomNote(), getRandomTonality(), getRandomSeventh());
    }

    private static Chord7Diminished5 createChord7Diminished5() {
        return new Chord7Diminished5(getRandomNote(), getRandomSeventhDim());
    }

    private static Note getRandomNote() {
        Note[] notes = Note.ROOTS.toArray(new Note[0]);
        return notes[random.nextInt(notes.length)];
    }

    private static Tonality getRandomTonality() {
        Tonality[] tonalities = Tonality.values();
        return tonalities[random.nextInt(tonalities.length)];
    }

    private static Interval getRandomSeventh() {
        Interval[] sevenths = {Interval.MAJOR_SEVENTH, Interval.MINOR_SEVENTH};
        return sevenths[random.nextInt(sevenths.length)];
    }

    private static Interval getRandomSeventhDim() {
        Interval[] sevenths = {Interval.MINOR_SEVENTH, Interval.DIMINISHED_SEVENTH};
        return sevenths[random.nextInt(sevenths.length)];
    }
}
