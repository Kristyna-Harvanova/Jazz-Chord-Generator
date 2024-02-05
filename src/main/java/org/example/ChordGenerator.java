package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Provides utility methods for generating random chords. This class can generate both individual chords
 * and lists of chords based on specified options, allowing for varied chord creation.
 */
public class ChordGenerator {
    /**
     * A {@code Random} instance for generating random values used in chord generation.
     */
    private static final Random random = new Random();

    /**
     * Generates a list of random chords based on the given option.
     *
     * @param numberOfChords The number of random chords to generate.
     * @param option The option that determines the type of the generated chords.
     * @return A list of {@code IChord} objects, each representing a random chord generated based on the specified option.
     */
    public static List<IChord> generateRandomChords(int numberOfChords, int option) {
        List<IChord> chords = new ArrayList<>();
        for (int i = 0; i < numberOfChords; i++) {
            chords.add(generateRandomChordForOption(option));
        }
        return chords;
    }

    /**
     * Generates a random chord based on the specified option.
     *
     * @param option The option that determines the type of the generated chord.
     * @return An {@code IChord} object representing the generated chord, or {@code null} if the option does not match any defined case.
     */
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

    /**
     * Generates a list of chords for a specified root note or a randomly chosen root note.
     * This method creates chords that all share the given root note but vary in other characteristics
     * such as tonality, intervals, or chord types.
     *
     * @param r The root note for which the chords will be generated.
     * @return A list of {@code IChord} objects, each representing a chord with the specified root note.
     */
    public static List<IChord> generateChordsForRoot(String r) {
        List<IChord> chords = new ArrayList<>();

        Note root;
        if (r.equalsIgnoreCase("R")) { root = getRandomNote(); }
        else { root = Note.fromString(r); }

        chords.add(new Chord(root, Tonality.MAJOR));
        chords.add(new Chord(root, Tonality.MINOR));
        chords.add(new ChordAugmented5(root));
        chords.add(new ChordSeventh(root, Tonality.MAJOR, Interval.MAJOR_SEVENTH));
        chords.add(new ChordSeventh(root, Tonality.MAJOR, Interval.MINOR_SEVENTH));
        chords.add(new ChordSeventh(root, Tonality.MINOR, Interval.MAJOR_SEVENTH));
        chords.add(new ChordSeventh(root, Tonality.MINOR, Interval.MINOR_SEVENTH));
        chords.add(new Chord7Diminished5(root, Interval.MINOR_SEVENTH));
        chords.add(new Chord7Diminished5(root, Interval.DIMINISHED_SEVENTH));

        return chords;
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
