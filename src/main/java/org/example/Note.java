package org.example;

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

    B_DOUBLE_FLAT(NoteName.B, Accidental.DOUBLE_FLAT),
    B_FLAT(NoteName.B, Accidental.FLAT),
    B(NoteName.B, Accidental.NATURAL),
    B_SHARP(NoteName.B, Accidental.SHARP),
    B_DOUBLE_SHARP(NoteName.B, Accidental.DOUBLE_SHARP);

    private final NoteName name;
    private final Accidental accidental;

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
        FLAT, SHARP, NATURAL, DOUBLE_SHARP, DOUBLE_FLAT;

        @Override
        public String toString() {
            return switch (this) {
                case FLAT -> "b";
                case SHARP -> "#";
                case NATURAL -> "";
                case DOUBLE_SHARP -> "x";
                case DOUBLE_FLAT -> "bb";
            };
        }
    }
}

