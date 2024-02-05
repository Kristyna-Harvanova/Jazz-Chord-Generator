package org.example;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class ChordBase  implements IChord {
    protected Note rootNote;
    protected Tonality tonality;
    protected List<Note> notesList;

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

    protected void addThird() {
        Interval interval = (tonality == Tonality.MAJOR) ? Interval.MAJOR_THIRD : Interval.MINOR_THIRD;
        addInterval(interval);
    }

    protected void addFifth() { addInterval(Interval.PERFECT_FIFTH); }

    protected void addNote(Note note) {
        notesList.add(note);
    }

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
