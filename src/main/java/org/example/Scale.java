package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scale {
    protected Note rootNote;
    protected ScaleType scaleType;
    protected List<Note> notesList;

    public Scale(Note rootNote, ScaleType scaleType) {
        this.rootNote = rootNote;
        this.scaleType = scaleType;
        this.notesList = new ArrayList<>();

        this.addNote(rootNote);
    }

    protected void addNote(Note note) {
        notesList.add(note);
    }

    protected void addInterval(Interval interval) {
        if (!Note.ROOTS.contains(rootNote)) { return; } //TODO: osetrit, ve kterych pripadech budu mit doubleAccidental root. Mozna nikde -> pak zrusit.
        int rootIndex = Note.INTERVALS.indexOf(rootNote);   // TODO: nahodne generovat z "ROOTS". Pokud bude feature, ze si uzivatel sam zada root, musi byt z ROOTS - kontrolovat.
        // TODO: Neprijimat jako root double flat/sharp, ale vlastne slo by. staci jen rozsirit nasi radu a pridat tony triple falt atd. Je to vubec pot5eba a bude to pekne?
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
}
