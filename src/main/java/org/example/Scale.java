package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a musical scale, defined by a root note and a scale type. A scale is a sequence of notes
 * that follows a certain set of intervals starting from the root note. This class allows for the creation
 * and manipulation of such scales, providing a foundation for musical theory applications.
 */
public class Scale {
    /**
     * The root note of the scale. This is the note from which the scale starts.
     */
    protected Note rootNote;

    /**
     * The type of the scale, such as Lydian, Aeolian, etc., defined by a predefined set of intervals.
     */
    protected ScaleType scaleType;

    /**
     * A list of {@code Note} objects representing the notes in the scale.
     */
    protected List<Note> notesList;

    /**
     * Constructs a {@code Scale} object with the specified root note and scale type.
     * The scale is built by adding notes starting from the root note, following the intervals defined by the scale type.
     *
     * @param rootNote The root note of the scale.
     * @param scaleType The type of the scale, which defines the intervals between consecutive notes.
     * @throws IllegalArgumentException If the root note is not one of the allowed root notes.
     */
    public Scale(Note rootNote, ScaleType scaleType) {
        if (!Note.ROOTS.contains(rootNote)) {
            throw new IllegalArgumentException("Invalid root note: " + rootNote + ". Allowed roots are C, D, E, F, G, A and B with accidentals #, b or None.");
        }

        this.rootNote = rootNote;
        this.scaleType = scaleType;
        this.notesList = new ArrayList<>();

        this.addNote(rootNote);
        this.addNotes();
    }

    /**
     * Adds a note to the scale.
     *
     * @param note The {@code Note} to be added to the scale.
     */
    protected void addNote(Note note) {
        notesList.add(note);
    }

    /**
     * Adds an interval to the scale from the last added note. This method calculates the next note based on the given interval
     * and adds it to the scale.
     *
     * @param interval The {@code Interval} to be added to the scale.
     */
    protected void addInterval(Interval interval) {
        int rootIndex = Note.INTERVALS.indexOf(rootNote);
        int shift = interval.getShift();
        Note note = Note.INTERVALS.get(rootIndex + shift);
        addNote(note);
    }

    /**
     * Builds the scale by adding notes according to the scale type. This method uses the intervals defined by the scale type
     * to add each note to the scale, starting from the root note.
     */
    protected void addNotes() {
        Interval[] intervals = scaleType.getIntervalsFromRoot();
        for (var interval : intervals) {
            addInterval(interval);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Note note : notesList) {
            sb.append(note.toString()).append(", ");
        }
        sb.setLength(sb.length() - 2); // Remove trailing comma and space
        return sb.toString();
    }

    public String getName() { return rootNote + " " + scaleType; }

    public List<Note> getNotes() {
        return notesList;
    }
}
