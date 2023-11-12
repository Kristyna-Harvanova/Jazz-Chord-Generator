package org.example;

public enum Note {
    C_FLAT(NoteName.C, Accidental.FLAT),
    C(NoteName.C, Accidental.NATURAL),
    C_SHARP(NoteName.C, Accidental.SHARP),

    D_FLAT(NoteName.D, Accidental.FLAT),
    D(NoteName.D, Accidental.NATURAL),
    D_SHARP(NoteName.D, Accidental.SHARP),

    E_FLAT(NoteName.E, Accidental.FLAT),
    E(NoteName.E, Accidental.NATURAL),
    E_SHARP(NoteName.E, Accidental.SHARP),

    F_FLAT(NoteName.F, Accidental.FLAT),
    F(NoteName.F, Accidental.NATURAL),
    F_SHARP(NoteName.F, Accidental.SHARP),

    G_FLAT(NoteName.G, Accidental.FLAT),
    G(NoteName.G, Accidental.NATURAL),
    G_SHARP(NoteName.G, Accidental.SHARP),

    A_FLAT(NoteName.A, Accidental.FLAT),
    A(NoteName.A, Accidental.NATURAL),
    A_SHARP(NoteName.A, Accidental.SHARP),

    B_FLAT(NoteName.B, Accidental.FLAT),
    B(NoteName.B, Accidental.NATURAL),
    B_SHARP(NoteName.B, Accidental.SHARP);

    private NoteName name;
    private Accidental accidental;

    @Override
    public String toString() {
        return this.name.toString() + accidental.toString();
    }

    Note(NoteName name, Accidental accidental) {
        this.name = name;
        this.accidental = accidental;
    }

    public enum NoteName {
        C, D, E, F, G, A, B;
    }

    public enum Accidental {
        FLAT, SHARP, NATURAL;

        @Override
        public String toString() {
            return switch (this) {
                case FLAT -> "b";
                case SHARP -> "#";
                case NATURAL -> "";
            };
        }
    }
}

