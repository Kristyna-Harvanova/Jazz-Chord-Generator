package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScaleGenerator {
    private static final Random random = new Random();

    public static List<Scale> generateRandomScales(int numberOfScales) {
        List<Scale> scales = new ArrayList<>();
        for (int i = 0; i < numberOfScales; i++) {
            scales.add(createScale());
        }
        return scales;
    }

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

