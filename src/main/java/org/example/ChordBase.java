package org.example;

import java.util.List;

public class ChordBase {
    protected Note rootNote;
    protected Tonality tonality;
    protected ScaleType scaleType;
    protected List<Note> notesList;

    public ChordBase(Note rootNote, Tonality tonality, ScaleType scaleType) {
        this.rootNote = rootNote;
        this.tonality = tonality;
        this.scaleType = scaleType;
        //this.notesList = new ArrayList<>();
    }

    protected void addNotes(Note note) {
        notesList.add(note);
    }

    protected void addThird() {

    }

    public String listAllNotes() {
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
}
