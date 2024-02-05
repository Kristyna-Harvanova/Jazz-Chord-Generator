
# Jazz Chord Generator: User Documentation

## Getting Started

### Prerequisites
- Ensure you have Java installed on your system. You can check this by running `java -version` in your command line or terminal. If Java is not installed, please download and install it from the [official website](https://www.oracle.com/java/technologies/downloads/).

### Running the Application
1. Open your command line or terminal.
2. Navigate to the directory where the `src` directory and `pom.xml` file are located.
3. Compile the Java files by running:
   ```
   mvn compile
   ```
4. Once compiled, start the application by running:
   ```
   mvn exec:java
   ```

## Using the Application

### Main Menu
- Upon launching, the application will display a welcome message followed by a prompt to start. Enter `S` key to proceed.
- You will then see the main menu offering the following options:
  - `[C]hords` - To practice with chord exercises.
  - `[S]cales` - To practice with scale exercises.
  - `[E]xit` - To close the application.

### Chord Exercises
- If you choose the chord exercises by entering `C`, you will be presented with different difficulty levels and chord types to choose from.
- Select an option by entering the corresponding number (1-6), where:
  - `1` is for Easy module (Basic triads exercising),
  - `2` is for Easy+ module (Basic triads and augmented fifth triads),
  - `3` is for Medium module (Seventh chords),
  - `4` is for Medium+ module (Seventh and diminished seventh chords),
  - `5` is for Hard module (All chord types),
  - `6` is for Special module (All chord types starting from a chosen or random root note will be able to practise).
- Follow the prompts to specify further details like the root note or the number of chords to generate.

### Scale Exercises
- If you choose the scale exercises by entering `S`, you will have options to focus on different aspects of scale practice:
  - `1` for Root-based exercises,
  - `2` for Type-based exercises,
  - `3` for Random scale exercises.
- Depending on your choice, you might need to input a specific root note, scale type, or the number of scales you wish to practice.
- Follow the on-screen instructions to proceed with the exercises.

### Exiting
- To exit the application, follow the instructions that will return you to the main menu and enter `E`.

### Additional Commands
- During exercises, you can request hints by pressing `H`. This will display additional information to assist you with the exercise.

## Tips for a Better Experience
- Ensure your inputs match the expected format (e.g., root notes should be in the form of 'C', 'A#', 'Bb', etc.).
- Take advantage of the hint feature to enhance your learning.
- Regularly practice with a variety of exercises to improve your musical theory knowledge.
