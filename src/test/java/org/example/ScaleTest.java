package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScaleTest {
    @Test
    public void IonianScaleTest() {
        Scale scale = new Scale(Note.C, ScaleType.IONIAN);
        assertEquals(List.of(Note.C, Note.D, Note.E, Note.F, Note.G, Note.A, Note.B, Note.C), scale.notesList);
    }

    @Test
    public void DorianScaleTest() {
        Scale scale = new Scale(Note.C, ScaleType.DORIAN);
        assertEquals(List.of(Note.C, Note.D, Note.E_FLAT, Note.F, Note.G, Note.A, Note.B_FLAT, Note.C), scale.notesList);
    }

    @Test
    public void PhrygianScaleTest() {
        Scale scale = new Scale(Note.C, ScaleType.PHRYGIAN);
        assertEquals(List.of(Note.C, Note.D_FLAT, Note.E_FLAT, Note.F, Note.G, Note.A_FLAT, Note.B_FLAT, Note.C), scale.notesList);
    }

    @Test
    public void LydianScaleTest() {
        Scale scale = new Scale(Note.C, ScaleType.LYDIAN);
        assertEquals(List.of(Note.C, Note.D, Note.E, Note.F_SHARP, Note.G, Note.A, Note.B, Note.C), scale.notesList);
    }

    @Test
    public void MixolydianScaleTest() {
        Scale scale = new Scale(Note.C, ScaleType.MIXOLYDIAN);
        assertEquals(List.of(Note.C, Note.D, Note.E, Note.F, Note.G, Note.A, Note.B_FLAT, Note.C), scale.notesList);
    }

    @Test
    public void AeolianScaleTest() {
        Scale scale = new Scale(Note.C, ScaleType.AEOLIAN);
        assertEquals(List.of(Note.C, Note.D, Note.E_FLAT, Note.F, Note.G, Note.A_FLAT, Note.B_FLAT, Note.C), scale.notesList);
    }

    @Test
    public void LocrianScaleTest() {
        Scale scale = new Scale(Note.C, ScaleType.LOCRIAN);
        assertEquals(List.of(Note.C, Note.D_FLAT, Note.E_FLAT, Note.F, Note.G_FLAT, Note.A_FLAT, Note.B_FLAT, Note.C), scale.notesList);
    }

    @Test
    public void AccidentalRootTest() {
        Scale scale = new Scale(Note.D_SHARP, ScaleType.IONIAN);
        assertEquals(List.of(Note.D_SHARP, Note.E_SHARP, Note.F_DOUBLE_SHARP, Note.G_SHARP, Note.A_SHARP, Note.B_SHARP, Note.C_DOUBLE_SHARP, Note.D_SHARP), scale.notesList);
    }
}
