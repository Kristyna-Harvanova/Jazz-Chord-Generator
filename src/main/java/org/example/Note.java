package org.example;

import java.util.List;

/**
 * Enumerates musical notes, including various accidentals such as flat, sharp, double flat, and double sharp.
 * Each note is associated with a base note name and an accidental, representing the full spectrum of notes
 * used in music composition and theory.
 */
public enum Note {
    C_DOUBLE_FLAT(NoteName.C, Accidental.DOUBLE_FLAT),
    C_FLAT(NoteName.C, Accidental.FLAT),
    C(NoteName.C, Accidental.NATURAL),
    C_SHARP(NoteName.C, Accidental.SHARP),
    C_DOUBLE_SHARP(NoteName.C, Accidental.DOUBLE_SHARP),

    D_DOUBLE_FLAT(NoteName.D, Accidental.DOUBLE_FLAT),
    D_FLAT(NoteName.D, Accidental.FLAT),
    D(NoteName.D, Accidental.NATURAL),
    D_SHARP(NoteName.D, Accidental.SHARP),
    D_DOUBLE_SHARP(NoteName.D, Accidental.DOUBLE_SHARP),


    E_TRIPLE_FLAT(NoteName.E, Accidental.TRIPLE_FLAT),
    E_DOUBLE_FLAT(NoteName.E, Accidental.DOUBLE_FLAT),
    E_FLAT(NoteName.E, Accidental.FLAT),
    E(NoteName.E, Accidental.NATURAL),
    E_SHARP(NoteName.E, Accidental.SHARP),
    E_DOUBLE_SHARP(NoteName.E, Accidental.DOUBLE_SHARP),

    F_DOUBLE_FLAT(NoteName.F, Accidental.DOUBLE_FLAT),
    F_FLAT(NoteName.F, Accidental.FLAT),
    F(NoteName.F, Accidental.NATURAL),
    F_SHARP(NoteName.F, Accidental.SHARP),
    F_DOUBLE_SHARP(NoteName.F, Accidental.DOUBLE_SHARP),
    F_TRIPLE_SHARP(NoteName.F, Accidental.TRIPLE_SHARP),


    G_DOUBLE_FLAT(NoteName.G, Accidental.DOUBLE_FLAT),
    G_FLAT(NoteName.G, Accidental.FLAT),
    G(NoteName.G, Accidental.NATURAL),
    G_SHARP(NoteName.G, Accidental.SHARP),
    G_DOUBLE_SHARP(NoteName.G, Accidental.DOUBLE_SHARP),

    A_DOUBLE_FLAT(NoteName.A, Accidental.DOUBLE_FLAT),
    A_FLAT(NoteName.A, Accidental.FLAT),
    A(NoteName.A, Accidental.NATURAL),
    A_SHARP(NoteName.A, Accidental.SHARP),
    A_DOUBLE_SHARP(NoteName.A, Accidental.DOUBLE_SHARP),

    B_TRIPLE_FLAT(NoteName.B, Accidental.TRIPLE_FLAT),
    B_DOUBLE_FLAT(NoteName.B, Accidental.DOUBLE_FLAT),
    B_FLAT(NoteName.B, Accidental.FLAT),
    B(NoteName.B, Accidental.NATURAL),
    B_SHARP(NoteName.B, Accidental.SHARP),
    B_DOUBLE_SHARP(NoteName.B, Accidental.DOUBLE_SHARP),
    B_TRIPLE_SHARP(NoteName.B, Accidental.TRIPLE_SHARP);


    /**
     * The base name of the note (e.g., C, D, E), without consideration of accidentals.
     */
    private final NoteName name;

    /**
     * The accidental associated with the note, such as FLAT, SHARP, NATURAL, etc.
     */
    private final Accidental accidental;

    @Override
    public String toString() {
        return this.name.toString() + accidental.toString();
    }

    /**
     * Constructs a {@code Note} enum constant with the specified note name and accidental.
     *
     * @param name The base name of the note (e.g., C, D, E).
     * @param accidental The accidental of the note (e.g., FLAT, SHARP, NATURAL).
     */
    Note(NoteName name, Accidental accidental) {
        this.name = name;
        this.accidental = accidental;
    }

    /**
     * Enumerates the base note names without accidentals.
     */
    public enum NoteName {
        C, D, E, F, G, A, B;
    }

    /**
     * Enumerates accidentals that can be applied to musical notes, including flats, sharps,
     * and their multiples. The {@code toString} method provides a string representation suitable
     * for musical notation.
     */
    public enum Accidental {
        FLAT, SHARP, NATURAL, DOUBLE_SHARP, DOUBLE_FLAT, TRIPLE_SHARP, TRIPLE_FLAT;

        @Override
        public String toString() {
            return switch (this) {
                case FLAT -> "b";
                case SHARP -> "#";
                case NATURAL -> "";
                case DOUBLE_SHARP -> "x";
                case DOUBLE_FLAT -> "bb";
                case TRIPLE_SHARP -> "#x";
                case TRIPLE_FLAT -> "bbb";
            };
        }
    }

    /**
     * Converts a string representation of a note into the corresponding {@code Note} enum constant.
     * This method handles standard musical notation for accidentals, converting them to the format
     * used in the enum constant names.
     *
     * @param noteStr The string representation of the note, such as "C#", "Bb", etc.
     * @return The corresponding {@code Note} enum constant, or {@code null} if no match is found.
     * @throws IllegalArgumentException If {@code Note} is null or empty, indicating an invalid or unspecified note.
     */
    public static Note fromString(String noteStr) {
        if (noteStr == null || noteStr.isEmpty()) {
            throw new IllegalArgumentException("Note string cannot be null or empty.");
        }

        String formattedNoteStr = noteStr;
        formattedNoteStr = formattedNoteStr.replace("#", "_SHARP");
        formattedNoteStr = formattedNoteStr.replace("b", "_FLAT");
        formattedNoteStr = formattedNoteStr.toUpperCase();

        try {
            return Note.valueOf(formattedNoteStr);
        } catch (IllegalArgumentException e) {
            //throw new IllegalArgumentException("No corresponding Note enum constant for: " + noteStr);
            return null;
        }
    }

    /**
     * A list of {@code Note} constants representing all possible root notes.
     */
    public static final List<Note> ROOTS = List.of(
            Note.F_FLAT, Note.C_FLAT, Note.G_FLAT, Note.D_FLAT, Note.A_FLAT, Note.E_FLAT, Note.B_FLAT, Note.F,
            Note.C, Note.G, Note.D, Note.A, Note.E, Note.B, Note.F_SHARP, Note.C_SHARP,
            Note.G_SHARP, Note.D_SHARP, Note.A_SHARP, Note.E_SHARP, Note.B_SHARP);

    /**
     * A list of {@code Note} constants representing intervals in order form of 45circle from triple flats to triple sharps.
     */
    public static final List<Note> INTERVALS = List.of(
            Note.E_TRIPLE_FLAT, Note.B_TRIPLE_FLAT, Note.F_DOUBLE_FLAT,
            Note.C_DOUBLE_FLAT, Note.G_DOUBLE_FLAT, Note.D_DOUBLE_FLAT, Note.A_DOUBLE_FLAT, Note.E_DOUBLE_FLAT, Note.B_DOUBLE_FLAT,
            Note.F_FLAT, Note.C_FLAT, Note.G_FLAT, Note.D_FLAT, Note.A_FLAT, Note.E_FLAT, Note.B_FLAT, Note.F,
            Note.C, Note.G, Note.D, Note.A, Note.E, Note.B, Note.F_SHARP, Note.C_SHARP,
            Note.G_SHARP, Note.D_SHARP, Note.A_SHARP, Note.E_SHARP, Note.B_SHARP,
            Note.F_DOUBLE_SHARP, Note.C_DOUBLE_SHARP, Note.G_DOUBLE_SHARP, Note.D_DOUBLE_SHARP, Note.A_DOUBLE_SHARP, Note.E_DOUBLE_SHARP,
            Note.B_TRIPLE_SHARP, Note.F_TRIPLE_SHARP);

    /**
     * Determines if the specified note is a root note.
     *
     * @param note The {@code Note} to check.
     * @return {@code true} if the note is a root note, otherwise {@code false}.
     */
    public static boolean IsRoot(Note note) {
        return ROOTS.contains(note);
    }
}

