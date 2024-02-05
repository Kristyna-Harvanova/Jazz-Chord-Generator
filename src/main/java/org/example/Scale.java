package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scale {
    protected Note rootNote;
    protected ScaleType scaleType;
    protected List<Note> notesList;

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

    protected void addNote(Note note) {
        notesList.add(note);
    }

    protected void addInterval(Interval interval) {
        int rootIndex = Note.INTERVALS.indexOf(rootNote);
        int shift = interval.getShift();
        Note note = Note.INTERVALS.get(rootIndex + shift);
        addNote(note);
    }

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
