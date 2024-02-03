package org.example;

import java.util.Scanner;
import java.util.List;

public class ChordGeneratorApp {
    private static final Scanner scanner = new Scanner(System.in);

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

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to the Jazz Chord Generator!\n" +
                "\n" +
                "Dear User,\n" +
                "We are pleased to introduce you to our Jazz Chord Training Tool, designed for musicians and students with an interest in the sophisticated realm of jazz harmony.\n" +
                "This tool serves as an educational resource aimed at enhancing your understanding and proficiency in jazz chord structures and providing an insight into scale composition.\n" +
                "\n" +
                "Please, press 'S' to start exercising.");
    }

    private static void waitForStartCommand() {
        String start = scanner.next();
        while (!"S".equalsIgnoreCase(start)) {
            System.out.println("Please, press 'S' to start exercising.");
            start = scanner.next();
        }
    }

    private static String getUserChoice() {
        System.out.println("If you want to start exercising jazz chords, press 'C'.\n" +
                "If you want to start exercising scales, press 'S'.\n" +
                "\n" +
                "To exit the application, press 'E'");
        String choice = scanner.next();
        while (!"S".equalsIgnoreCase(choice) && !"C".equalsIgnoreCase(choice) && !"E".equalsIgnoreCase(choice)) {
            System.out.println("Please, press 'C' for chords or 'S' for scales.\n" +
                    "You can exit the application via pressing 'E'.");
            choice = scanner.next();
        }
        return choice;
    }

    private static void exerciseChords() {
        displayOptions();
        int option = getOptionNumber();

        System.out.println("How many chords do you want to generate?");
        int numberOfChords = getNumberOfChords();

        List<IChord> randomChords = ChordGenerator.generateRandomChords(numberOfChords, option);

        displayChords(randomChords);
        waitForHintCommand();
        displayChordsWithNotes(randomChords);
    }

    private static void displayOptions() {
        System.out.println("Please choose one of the following training modules by pressing the option number.");
        System.out.println("Option 1:    Easy        - Basic triads.");
        System.out.println("Option 2:    Easy+       - Basic triads and triads with augmented fifth.");
        System.out.println("Option 3:    Medium      - Seventh chords.");
        System.out.println("Option 4:    Medium+     - Seventh chords and diminished seventh chords.");
        System.out.println("Option 5:    Hard        - All chord types.");
    }

    private static int getOptionNumber() {
        int option = -1;
        while (option < 1 || option > 5) {
            try {
                option = scanner.nextInt(); // Attempt to read an integer from the user
                if (option < 1 || option > 5) {
                    System.out.println("Please enter one of the following option numbers: '1', '2', '3', '4' or '5'.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option number.");
                scanner.next();
            }
        }
        return option;
    }

    private static int getNumberOfChords() {
        int numberOfChords = -1; // Initialize with an invalid value to enter the loop

        while (numberOfChords <= 0) {
            try {
                numberOfChords = scanner.nextInt(); // Attempt to read an integer from the user
                if (numberOfChords <= 0) {
                    System.out.println("The number of chords cannot be non-positive. Please try again inserting a positive integer.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid positive integer.");
                scanner.next();
            }
        }
        return numberOfChords;
    }

    private static void displayChords(List<IChord> randomChords) {
        int i = 0;
        for (IChord chord : randomChords) {
            System.out.printf("Chord %d:\t%s%n", i++ + 1, chord.getName());
        }
        System.out.println();
    }

    private static void waitForHintCommand() {
        System.out.println("For displaying a hint, press H.");

        String hint = scanner.next();
        while (!"H".equalsIgnoreCase(hint)) {
            System.out.println("For displaying a hint, press H.");
            hint = scanner.next();
        }
    }

    private static void displayChordsWithNotes(List<IChord> randomChords) {
        int i = 0;
        for (IChord chord : randomChords) {
            System.out.printf("Chord %d:\t%-8s\t%s%n", i++ + 1, chord.getName(), chord.getNotes());
        }
        System.out.println();
    }

    private static void exerciseScales() {

    }
}
