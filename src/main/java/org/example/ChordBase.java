package org.example;

import java.util.ArrayList;
import java.util.Arrays;
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
        this.notesList = new ArrayList<>();
    }

    //protected static final Note[] NAT_ROOTS_SHARPS = new Note[]{ Note.C, Note.G, Note.D, Note.A, Note.E, Note.B };
    //protected static final Note[] SHARPS_FOR_ROOTS_NAT = new Note[]{ Note.C, Note.C_SHARP, Note.D, Note.D_SHARP, Note.E, Note.F, Note.F_SHARP, Note.G, Note.G_SHARP, Note.A, Note.A_SHARP, Note.B };
    protected static final List<Note> NAT_ROOTS_SHARPS = List.of(Note.C, Note.G, Note.D, Note.A, Note.E, Note.B);
    protected static final List<Note> SHA_ROOTS_SHARPS = List.of(Note.F_SHARP, Note.C_SHARP, Note.G_SHARP, Note.D_SHARP, Note.A_SHARP, Note.E_SHARP);
    protected static final List<Note> NAT_ROOTS_FLATS = List.of(Note.F, Note.B_FLAT, Note.E_FLAT, Note.A_FLAT, Note.D_FLAT, Note.G_FLAT);
    protected static final List<Note> FLA_ROOTS_FLATS = List.of(Note.C_FLAT, Note.F_FLAT); //, Note.B_DOUBLE_FLAT, Note.E_DOUBLE_FLAT, Note.A_DOUBLE_FLAT, Note.D_DOUBLE_FLAT, Note.G_DOUBLE_FLAT);

    protected static final List<Note> SHARPS_FOR_ROOTS_NAT = List.of(Note.C, Note.C_SHARP, Note.D, Note.D_SHARP, Note.E, Note.F, Note.F_SHARP, Note.G, Note.G_SHARP, Note.A, Note.A_SHARP, Note.B);
    protected static final List<Note> SHARPS_FOR_ROOTS_SHA = List.of(Note.B_SHARP, Note.C_SHARP, Note.C_DOUBLE_SHARP, Note.D_SHARP, Note.D_DOUBLE_SHARP, Note.E_SHARP, Note.F_SHARP, Note.F_DOUBLE_SHARP, Note.G_SHARP, Note.G_DOUBLE_SHARP, Note.A_SHARP, Note.B);
    protected static final List<Note> FLATS_FOR_ROOTS_NAT = List.of(Note.C, Note.D_FLAT, Note.D, Note.E_FLAT, Note.E, Note.F, Note.G_FLAT, Note.G, Note.A_FLAT, Note.A, Note.B_FLAT, Note.B);
    protected static final List<Note> FLATS_FOR_ROOTS_FLA = List.of(Note.D_DOUBLE_FLAT, Note.D_FLAT, Note.E_DOUBLE_FLAT, Note.E_FLAT, Note.F_FLAT, Note.G_DOUBLE_FLAT, Note.G_FLAT, Note.A_DOUBLE_FLAT, Note.A_FLAT, Note.B_DOUBLE_FLAT, Note.B_FLAT, Note.C_FLAT);



    protected void addNote(Note note) {
        notesList.add(note);
    }

    protected void addThirdx() {
        /*Note[] rootNat = new Note[]{ Note.C, Note.G, Note.D, Note.A, Note.E, Note.B };
        *//*List<Note> rootNat = new ArrayList<Note>() { };
        rootNat.add(Note.C);
        rootNat.add(Note.G);
        rootNat.add(Note.D);
        rootNat.add(Note.A);
        rootNat.add(Note.E);
        rootNat.add(Note.B);*//*

        Note[] forSharpsRootNat = new Note[]{ Note.C, Note.C_SHARP, Note.D, Note.D_SHARP, Note.E, Note.F, Note.F_SHARP, Note.G, Note.G_SHARP, Note.A, Note.A_SHARP, Note.B };

        *//*ArrayList<Note> forSharpsRootNat = new ArrayList<>() {};
        forSharpsRootNat.add(Note.C);
        forSharpsRootNat.add(Note.C_SHARP);
        forSharpsRootNat.add(Note.D);
        forSharpsRootNat.add(Note.D_SHARP);
        forSharpsRootNat.add(Note.E);
        forSharpsRootNat.add(Note.F);
        forSharpsRootNat.add(Note.F_SHARP);
        forSharpsRootNat.add(Note.G);
        forSharpsRootNat.add(Note.G_SHARP);
        forSharpsRootNat.add(Note.A);
        forSharpsRootNat.add(Note.A_SHARP);
        forSharpsRootNat.add(Note.B);*/


        if (NAT_ROOTS_SHARPS.contains(rootNote)) {
            int rootIndex = SHARPS_FOR_ROOTS_NAT.indexOf(rootNote);
            Interval interval = (tonality == Tonality.MAJOR) ? org.example.Interval.MAJOR_THIRD : org.example.Interval.MINOR_THIRD;
            Note third = SHARPS_FOR_ROOTS_NAT.get((rootIndex + interval.getSemitones()) % SHARPS_FOR_ROOTS_NAT.size());

            addNote(third);
        }
    }

    protected void addThird() {
        List<Note> notes = getNotesList(rootNote);
        if (notes != null) {    //TODO: az se nebude v getNotesList vracet null, tak zrusit.
            int rootIndex = notes.indexOf(rootNote);
            Interval interval = (tonality == Tonality.MAJOR) ? Interval.MAJOR_THIRD : Interval.MINOR_THIRD;
            Note third = notes.get((rootIndex + interval.getSemitones()) % notes.size());

            addNote(third);
        }
    }

    //TODO: takto vlastne asi nebude fungovat pro moll. Zkusit vygenerovat jednotlive stupnice Scales se ScaleType a podle nich hledat tercie atd.?
    private List<Note> getNotesList(Note rootNote) {
        if (NAT_ROOTS_SHARPS.contains(rootNote)) {
            return SHARPS_FOR_ROOTS_NAT;
        } else if (SHA_ROOTS_SHARPS.contains(rootNote)) {
            return SHARPS_FOR_ROOTS_SHA;
        } else if (NAT_ROOTS_FLATS.contains(rootNote)) {
            return FLATS_FOR_ROOTS_NAT;
        } else if (FLA_ROOTS_FLATS.contains(rootNote)) {
            return FLATS_FOR_ROOTS_FLA;
        } else {
            return null;    //TODO: oddelat null, po zajisteni nahodnem generovani jen danych not jako rootNote ... napr ne Cbb, Cx...
        }
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
        return rootNote.toString() + tonality.toString() + notesList.toString();
    }
}
