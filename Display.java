import java.util.Scanner;

public class Display {
    GameBoard board;
    Scanner input;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public Display(GameBoard board, Scanner input) {
        this.board = board;
        this.input = input;
    }

    // Prints out the board
    // Prints out previous guesses and remaining attempts
    public void print() {
        printGuesses();
        printBlanks();
        clear();
    }

    // Clears the terminal
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Prompts user to type in a guess from the terminal
    // Will only take in words of an appropriate length
    public String promptGuess() {
        while (true) {
            System.out.println("Enter a word:");
            String guess = input.nextLine().toUpperCase();
            if (guess.length() != board.getWord().length()) {
                System.out.println("Please enter word of length " + board.getWord().length());
            } else {
                board.guess(guess);
                return guess;
            }
        }
    }

    // Prints out previous guesses on the board with appropriate feedback
    // Prints out characters of the guesses separated by "|"
    public void printGuesses() {

        StringBuilder builder = new StringBuilder();
        for (String guess : board.guesses) {

            for (int i = 0; i < guess.length(); i++) {
                String answer = board.getWord();
                char letter = guess.charAt(i);

                // letter is in correct place
                if (answer.charAt(i) == letter) {
                    builder.append(ANSI_GREEN + letter + ANSI_RESET);
                // letter is contained in answer
                } else if (answer.contains(Character.toString(letter))) {
                    builder.append(ANSI_YELLOW + letter + ANSI_RESET);
                } else {
                    builder.append(letter);
                }
                builder.append("|");
            }

            builder.setLength((builder.length() - 1));
            System.out.println(builder.toString());
            builder = new StringBuilder();
        }
    }

    // prints out spaces for remaining attempts
    public void printBlanks() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.getAttemptsRemaining(); i++) {
            for (int j = 0; j < board.getWord().length(); j++) {
                builder.append("_|");
            }
            builder.setLength(builder.length() - 1);
            System.out.println(builder.toString());
            builder = new StringBuilder();
        }
    }
}