import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {
    //Initializing all variables for GameBoard
    private int rowLength;
    private int attemptsRemaining;
    private int attempts;
    private String word;
    List<String> guesses;

    public GameBoard(List<String> list) {
        word = list.get(new Random().nextInt(list.size())).toUpperCase();
        rowLength = word.length();
        attempts = 6;
        attemptsRemaining = attempts;
        guesses = new ArrayList<String>();
        System.out.println(word);
    }
    //Getter methods
    public int getRowLength() {
        return rowLength;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getAttemptsRemaining() {
        return attemptsRemaining;
    }

    public String getWord() {
        return word;
    }

    public List<String> getGuesses() {
        return guesses;
    }
    //Setter Methods
    public void setRowLength(int rowLength) {
        this.rowLength = rowLength;
    }

    public void setAttemptsRemaining(int attemptsRemaining) {
        this.attemptsRemaining = attemptsRemaining;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setGuesses(List<String> guesses) {
        this.guesses = guesses;
    }
    //Method to check if game is over
    public boolean isGameOver () {
        return attemptsRemaining == 0 || didWin();
    }
    //Method to check if guess was correct
    public boolean didWin() {
        return guesses.contains(word);
    }
    //validates if guess is of correct length
    public void guess(String s) {
        if (s.length() == word.length()) {
            guesses.add(s);
            attemptsRemaining--;
        }
    }
}