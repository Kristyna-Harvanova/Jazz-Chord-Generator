package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ChordBase} class serves as a foundation for representing musical chords. It implements
 * the {@code IChord} interface and provides basic functionalities common to all chords, such as managing
 * the root note, tonality, and the list of notes that make up the chord.
 */
public class ChordBase  implements IChord {
    /**
     * The root note of the chord.
     */
    protected Note rootNote;

    /**
     * The tonality of the chord, determining its major or minor quality.
     */
    protected Tonality tonality;

    /**
     * A list of {@code Note} objects representing the notes that make up the chord.
     */
    protected List<Note> notesList;

    /**
     * Constructs a {@code ChordBase} object with the specified root note and tonality.
     * Initializes the list of notes and adds the root note and the third interval based on the tonality.
     *
     * @param rootNote The root note of the chord.
     * @param tonality The tonality of the chord, either MAJOR or MINOR.
     * @throws IllegalArgumentException If the root note is not one of the allowed root notes.
     */
    public ChordBase(Note rootNote, Tonality tonality) {
        if (!Note.ROOTS.contains(rootNote)) {
            throw new IllegalArgumentException("Invalid root note: " + rootNote + ". Allowed roots are C, D, E, F, G, A and B with accidentals #, b or None.");
        }

        this.rootNote = rootNote;
        this.tonality = tonality;
        this.notesList = new ArrayList<>();

        this.addNote(rootNote);
        this.addThird();
    }

    /**
     * Adds the third interval to the chord, which can be either a major or minor third based on the chord's tonality.
     */
    protected void addThird() {
        Interval interval = (tonality == Tonality.MAJOR) ? Interval.MAJOR_THIRD : Interval.MINOR_THIRD;
        addInterval(interval);
    }

    /**
     * Adds the fifth interval to the chord, defaulted to a perfect fifth.
     */
    protected void addFifth() { addInterval(Interval.PERFECT_FIFTH); }

    /**
     * Adds a single note to the chord.
     *
     * @param note The {@code Note} to be added to the chord.
     */
    protected void addNote(Note note) {
        notesList.add(note);
    }

    /**
     * Adds an interval to the chord starting from the root note. This method calculates the note
     * that lies the specified interval away from the root note and adds it to the chord's list of notes.
     *
     * @param interval The {@code Interval} to be added to the chord from the root note.
     */
    protected void addInterval(Interval interval) {
        int rootIndex = Note.INTERVALS.indexOf(rootNote);
        int shift = interval.getShift();
        Note note = Note.INTERVALS.get(rootIndex + shift);
        addNote(note);
    }

    protected String listAllNotes() {
        StringBuilder sb = new StringBuilder();
        for (Note note : notesList) {
            sb.append(note.toString()).append(", ");
        }
        sb.setLength(sb.length() - 2); // Remove trailing comma and space
        return sb.toString();
    }

    @Override
    public String toString() {
        return rootNote.toString() + tonality.toString();
    }

    @Override
    public String getName() {
        return toString();
    }

    @Override
    public List<Note> getNotes() {
        return notesList;
    }
}
