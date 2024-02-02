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

    //TODO: have this only once for whole solution, but where or how?
    protected static final List<Note> ROOTS = List.of(
            Note.F_FLAT, Note.C_FLAT, Note.G_FLAT, Note.D_FLAT, Note.A_FLAT, Note.E_FLAT, Note.B_FLAT, Note.F,
            Note.C, Note.G, Note.D, Note.A, Note.E, Note.B, Note.F_SHARP, Note.C_SHARP,
            Note.G_SHARP, Note.D_SHARP, Note.A_SHARP, Note.E_SHARP, Note.B_SHARP);
    protected static final List<Note> INTERVALS = List.of(
            Note.C_DOUBLE_FLAT, Note.G_DOUBLE_FLAT, Note.D_DOUBLE_FLAT, Note.A_DOUBLE_FLAT, Note.E_DOUBLE_FLAT, Note.B_DOUBLE_FLAT,
            Note.F_FLAT, Note.C_FLAT, Note.G_FLAT, Note.D_FLAT, Note.A_FLAT, Note.E_FLAT, Note.B_FLAT, Note.F,
            Note.C, Note.G, Note.D, Note.A, Note.E, Note.B, Note.F_SHARP, Note.C_SHARP,
            Note.G_SHARP, Note.D_SHARP, Note.A_SHARP, Note.E_SHARP, Note.B_SHARP,
            Note.F_DOUBLE_SHARP, Note.C_DOUBLE_SHARP, Note.G_DOUBLE_SHARP, Note.D_DOUBLE_SHARP, Note.A_DOUBLE_SHARP, Note.E_DOUBLE_SHARP);

    protected void addNote(Note note) {
        notesList.add(note);
    }

    protected void addInterval(Interval interval) {
        if (!ROOTS.contains(rootNote)) { return; } //TODO: osetrit, ve kterych pripadech budu mit doubleAccidental root. Mozna nikde -> pak zrusit.
        int rootIndex = INTERVALS.indexOf(rootNote);   // TODO: nahodne generovat z "ROOTS". Pokud bude feature, ze si uzivatel sam zada root, musi byt z ROOTS - kontrolovat.
        // TODO: Neprijimat jako root double flat/sharp, ale vlastne slo by. staci jen rozsirit nasi radu a pridat tony triple falt atd. Je to vubec pot5eba a bude to pekne?
        int shift = interval.getShift();
        Note note = INTERVALS.get(rootIndex + shift);
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
