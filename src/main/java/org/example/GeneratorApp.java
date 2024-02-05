package org.example;

import java.util.Scanner;
import java.util.List;

/**
 * The main application class for a generator tool, designed to provide exercises for chords and scales.
 * This class handles user interactions, offering options to practice with chords or scales, and continues
 * to prompt the user until an exit command is issued.
 */
public class GeneratorApp {
    /**
     * Scanner instance to read user input from the console.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * The entry point of the application. This method displays a welcome message, waits for a start command,
     * and then enters a loop to process user choices for practicing chords or scales until an exit command is given.
     *
     * @param args Command-line arguments passed to the application (not used).
     */
    public static void main(String[] args) {
        displayWelcomeMessage();
        waitForStartCommand();

        String choice = getUserChoice();
        while (!"E".equalsIgnoreCase(choice)) {
            if ("C".equalsIgnoreCase(choice)) { exerciseChords(); }
            else if ("S".equalsIgnoreCase(choice)) { exerciseScales(); }
            choice = getUserChoice();
        }

        scanner.close();
    }

    /**
     * Displays a welcome message to the user at the start of the application.
     */
    private static void displayWelcomeMessage() {
        System.out.println("""
                Welcome to the Jazz Chord Generator!

                Dear User,
                We are pleased to introduce you to our Jazz Chord Training Tool, designed for musicians and students with an interest in the sophisticated realm of jazz harmony.
                This tool serves as an educational resource aimed at enhancing your understanding and proficiency in jazz chord structures and providing an insight into scale composition.

                Please, press 'S' to start exercising.""");
    }

    /**
     * Waits for a start command from the user to begin the exercises.
     */
    private static void waitForStartCommand() {
        String start = scanner.next();
        while (!"S".equalsIgnoreCase(start)) {
            System.out.println("Please, press 'S' to start exercising.");
            start = scanner.next();
        }
    }

    /**
     * Prompts the user to choose between practicing chords or scales or exiting the application.
     *
     * @return The user's choice as a {@code String}.
     */
    private static String getUserChoice() {
        System.out.println("""
                If you want to start exercising jazz chords, press 'C'.
                If you want to start exercising scales, press 'S'.

                To exit the application, press 'E'""");

        String choice = scanner.next();
        while (!"S".equalsIgnoreCase(choice) && !"C".equalsIgnoreCase(choice) && !"E".equalsIgnoreCase(choice)) {
            System.out.println("Please, press 'C' for chords or 'S' for scales.\n" +
                    "You can exit the application via pressing 'E'.");
            choice = scanner.next();
        }
        return choice;
    }

    /**
     * Initiates the chord exercise. This method might generate random chords, display them to the user,
     * and handle user input specifying the chords exercise.
     */
    private static void exerciseChords() {
        displayOptionsForChords();
        int option = getOptionNumber(6);

        List<IChord> generatedChords;
        if (option == 6) {
            System.out.println("Insert a root note (eg.: 'D', 'C#' or 'Bb') you want to practice or press 'R' for a random root.");
            String root = getRoot();
            generatedChords = ChordGenerator.generateChordsForRoot(root);
        } else {
            System.out.println("How many chords do you want to generate?");
            int numberOfChords = getNumberOfChordsOrScales();
            generatedChords = ChordGenerator.generateRandomChords(numberOfChords, option);
        }

        displayChords(generatedChords);
        waitForHintCommand();
        displayChordsWithNotes(generatedChords);
    }

    /**
     * Displays the available chord training module options to the user.
     * The options range from easy to hard, each with a different focus on chord types.
     */
    private static void displayOptionsForChords() {
        System.out.println("Please choose one of the following training modules by pressing the option number.");
        System.out.println("Option 1:    Easy        - Basic triads.");
        System.out.println("Option 2:    Easy+       - Basic triads and triads with augmented fifth.");
        System.out.println("Option 3:    Medium      - Seventh chords.");
        System.out.println("Option 4:    Medium+     - Seventh chords and diminished seventh chords.");
        System.out.println("Option 5:    Hard        - All chord types.");
        System.out.println("Option 6:    Special     - All chord types starting from entered or random root.");
    }

    /**
     * Reads and validates the user's option number input against the provided number of options.
     *
     * @param numberOfOptions The total number of valid options available to the user.
     * @return The validated option number chosen by the user.
     */
    private static int getOptionNumber(int numberOfOptions) {
        int option = -1;
        while (option < 1 || option > numberOfOptions) {
            try {
                option = scanner.nextInt(); // Attempt to read an integer from the user
                if (option < 1 || option > numberOfOptions) {
                    int i = 1;
                    System.out.print("Please enter one of the following option numbers: ");
                    while (i < numberOfOptions) System.out.print("'" + i++ + "', ");
                    System.out.print("'" + i + "'.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option number.");
                scanner.next();
            }
        }
        return option;
    }

    /**
     * Prompts the user to enter a musical note as the root for chords or scales, or 'R' for a random root.
     * Validates the input to ensure it corresponds to a valid musical note or the 'R' character.
     *
     * @return The root note entered by the user as a {@code String}, or 'R' for random.
     */
    private static String getRoot() {
        String s = scanner.next();
        while (!"R".equalsIgnoreCase(s) && !IsRoot(s)) {
            System.out.println("Insert a valid format of a root note (eg.: 'D', 'C#' or 'Bb') or press 'R' for a random root.");
            s = scanner.next();
        }
        return s;
    }

    /**
     * Checks if the provided string corresponds to a valid musical root note.
     *
     * @param s The string to check.
     * @return {@code true} if the string is a valid root note, {@code false} otherwise.
     */
    private static boolean IsRoot(String s) {
        Note note = Note.fromString(s);
        if (note == null) { return false; }
        return Note.IsRoot(note);
    }

    /**
     * Prompts the user to enter the number of chords or scales they wish to generate, ensuring the input is a positive integer.
     *
     * @return The number of chords or scales to be generated, as entered by the user.
     */
    private static int getNumberOfChordsOrScales() {
        int numberOfChords = -1; // Initialize with an invalid value to enter the loop

        while (numberOfChords <= 0) {
            try {
                numberOfChords = scanner.nextInt(); // Attempt to read an integer from the user
                if (numberOfChords <= 0) {
                    System.out.println("The number cannot be non-positive. Please try again inserting a positive integer.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid positive integer.");
                scanner.next();
            }
        }
        return numberOfChords;
    }

    /**
     * Displays the generated list of chords to the user, each with an ordinal number for reference.
     *
     * @param Chords The list of randomly generated {@code IChord} objects to display.
     */
    private static void displayChords(List<IChord> Chords) {
        int i = 0;
        for (IChord chord : Chords) {
            System.out.printf("Chord %d:\t%s%n", i++ + 1, chord.getName());
        }
        System.out.println();
    }

    /**
     * Waits for the user to request a hint by pressing 'H', facilitating the learning process during exercises.
     */
    private static void waitForHintCommand() {
        System.out.println("For displaying a hint, press H.");

        String hint = scanner.next();
        while (!"H".equalsIgnoreCase(hint)) {
            System.out.println("For displaying a hint, press H.");
            hint = scanner.next();
        }
    }

    /**
     * Displays the generated list of chords with their respective names and notes.
     *
     * @param randomChords The list of {@code IChord} objects whose details are to be displayed.
     */
    private static void displayChordsWithNotes(List<IChord> randomChords) {
        int i = 0;
        for (IChord chord : randomChords) {
            System.out.printf("Chord %d:\t%-8s\t%s%n", i++ + 1, chord.getName(), chord.getNotes());
        }
        System.out.println();
    }

    /**
     * Initiates the scale exercise. Similar to the chords exercise, this method generate scales,
     * present them to the user, and handle any related user interactions.
     */
    private static void exerciseScales() {
        displayOptionsForScales();
        int option = getOptionNumber(3);

        List<Scale> generatedScales;
        if (option == 1) {
            System.out.println("Insert a root note (eg.: 'D', 'C#' or 'Bb') you want to practice or press 'R' for a random root.");
            String root = getRoot();
            generatedScales = ScaleGenerator.generateScalesForRoot(root);
        } else if (option == 2) {
            System.out.println("Insert a type of a scale (eg.: 'Ionian' or 'Lydian') you want to practice or press 'R' for a random scale type.");
            String scaleType = getScaleType();
            generatedScales = ScaleGenerator.generateGivenScaleForAllRoots(scaleType);
        } else { // if (option == 3) {
            System.out.println("How many scales do you want to generate?");
            int numberOfScales = getNumberOfChordsOrScales();
            generatedScales = ScaleGenerator.generateRandomScales(numberOfScales);

        }

        displayScales(generatedScales);
        waitForHintCommand();
        displayScalesWithNotes(generatedScales);
    }

    /**
     * Displays the available scale training module options to the user, ranging from root-based to random scale generation.
     */
    private static void displayOptionsForScales() {
        System.out.println("Please choose one of the following training modules by pressing the option number.");
        System.out.println("Option 1:    Root-based  - All types of scales for a given root will be generated.");
        System.out.println("Option 2:    Type-based  - Chosen scale type will be generated for all possible roots.");
        System.out.println("Option 3:    Random      - Random scales will be generated.");
    }

    /**
     * Prompts the user to enter a scale type for the exercise, or 'R' for a random scale type, validating the input.
     *
     * @return The scale type entered by the user as a {@code String}, including 'R' for random.
     */
    private static String getScaleType() {
        String s = scanner.next();
        while (!"R".equalsIgnoreCase(s) && !IsScaleType(s)) {
            System.out.println("Press 'R' for a random scale type or insert one of the following types of a scales: 'Ionian', 'Dorian', 'Phrygian', 'Lydian', 'Mixolydian', 'Aeolian', 'Locrian'.");
            s = scanner.next();
        }
        return s;
    }

    /**
     * Verifies if the provided string corresponds to a valid scale type defined in the application.
     *
     * @param s The string to check.
     * @return {@code true} if the string is a valid scale type, {@code false} otherwise.
     */
    private static boolean IsScaleType(String s) {
        ScaleType scaleType = ScaleType.fromString(s);
        return scaleType != null;
    }

    /**
     * Displays the generated list of scales to the user, each with an ordinal number for reference.
     *
     * @param scales The list of {@code Scale} objects to display.
     */
    private static void displayScales(List<Scale> scales) {
        int i = 0;
        for (Scale scale : scales) {
            System.out.printf("Scale %d:\t%s%n", i++ + 1, scale.getName());
        }
        System.out.println();
    }

    /**
     * Displays the generated list of scales with their respective names and notes, providing detailed insights for the user.
     *
     * @param scales The list of {@code Scale} objects whose details are to be displayed.
     */
    private static void displayScalesWithNotes(List<Scale> scales) {
        int i = 0;
        for (Scale scale : scales) {
            System.out.printf("Scale %d:\t%-14s\t%s%n", i++ + 1, scale.getName(), scale.getNotes());
        }
        System.out.println();
    }
}
