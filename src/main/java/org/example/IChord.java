package org.example;

import java.util.List;

/**
 * Defines the contract for chord objects within the application. This interface ensures that implementing
 * classes provide methods to retrieve the chord's name and the list of notes that constitute the chord.
 */
public interface IChord {
    /**
     * Retrieves the name of the chord.
     *
     * @return The name of the chord as a {@code String}.
     */
    String getName();

    /**
     * Retrieves the list of notes that make up the chord.
     *
     * @return A list of {@code Note} objects representing the notes in the chord.
     */
    List<Note> getNotes();
}
