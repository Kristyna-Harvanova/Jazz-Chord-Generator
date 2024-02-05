package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Provides functionality to generate musical scales, either randomly or based on a specific root note.
 * This class supports the creation of various scales, including all modes (Ionian, Dorian, etc.),
 * allowing for diverse musical applications and analyses.
 */
public class ScaleGenerator {
    /**
     * A {@code Random} instance for generating random values, used in selecting random notes or scale types.
     */
    private static final Random random = new Random();

    /**
     * Generates a list of random scales.
     *
     * @param numberOfScales The number of random scales to generate.
     * @return A list of {@code Scale} objects, each representing a randomly generated scale.
     */
    public static List<Scale> generateRandomScales(int numberOfScales) {
        List<Scale> scales = new ArrayList<>();
        for (int i = 0; i < numberOfScales; i++) {
            scales.add(createScale());
        }
        return scales;
    }

    /**
     * Generates scales for a specified root note. This method creates scales for all modes
     * (Ionian, Dorian, Phrygian, Lydian, Mixolydian, Aeolian, and Locrian) based on the given root note.
     *
     * @param r The root note for the scales, specified as a string. Can be a note name (e.g., "C", "A#", "Eb")
     *          or "R" for a random root note.
     * @return A list of {@code Scale} objects, each representing a scale with the specified root note.
     */
    public static List<Scale> generateScalesForRoot(String r) {
        List<Scale> scales = new ArrayList<>();

        Note root;
        if (r.equalsIgnoreCase("R")) { root = getRandomNote(); }
        else { root = Note.fromString(r); }

        scales.add(new Scale(root, ScaleType.IONIAN));
        scales.add(new Scale(root, ScaleType.DORIAN));
        scales.add(new Scale(root, ScaleType.PHRYGIAN));
        scales.add(new Scale(root, ScaleType.LYDIAN));
        scales.add(new Scale(root, ScaleType.MIXOLYDIAN));
        scales.add(new Scale(root, ScaleType.AEOLIAN));
        scales.add(new Scale(root, ScaleType.LOCRIAN));

        return scales;
    }

    /**
     * Generates a specified scale type for all possible root notes defined in {@code Note.ROOTS}.
     * This method can create a series of scales, each starting from a different root note but all following
     * the same scale type, providing a comprehensive set of scales across all keys.
     *
     * @param s The scale type to be generated for all root notes. Can be a scale type name (e.g., "Ionian", "Dorian")
     *          or "R" for a random scale type.
     * @return A list of {@code Scale} objects, each representing the given scale type starting from a different root note.
     */
    public static List<Scale> generateGivenScaleForAllRoots(String s) {
        List<Scale> scales = new ArrayList<>();

        ScaleType scaleType;
        if (s.equalsIgnoreCase("R")) { scaleType = getRandomScaleType(); }
        else { scaleType = ScaleType.fromString(s); }

        for (Note root : Note.ROOTS) {
            scales.add(new Scale(root, scaleType));
        }

        return scales;
    }

    private static Scale createScale() {
        return new Scale(getRandomNote(), getRandomScaleType());
    }

    private static Note getRandomNote() {
        Note[] notes = Note.ROOTS.toArray(new Note[0]);
        return notes[random.nextInt(notes.length)];
    }

    private static ScaleType getRandomScaleType() {
        ScaleType[] scaleTypes = ScaleType.values();
        return scaleTypes[random.nextInt(scaleTypes.length)];
    }
}

