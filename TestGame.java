import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class TestGame {
    public static void main(String[] args) throws IOException {
    	String word;
        List<String> list = new ArrayList<String>();
		File wordlist = new File("C:\\Users\\Sofwan Mohammed\\Desktop\\Projects\\Wordle_clone\\sorted wordle list.txt");
		BufferedReader reader = new BufferedReader(new FileReader(wordlist));
		
		while((word=reader.readLine()) != null) {
			list.add(word);
		}
        GameBoard board = new GameBoard(list);

        Scanner input = new Scanner(System.in);

        Display display = new Display(board, input);
        while (!board.isGameOver()) {
            display.print();
            display.promptGuess();
        }
        display.print();
        if (board.didWin()) {
            System.out.println("Congratulations, you guessed correctly");
        } else {
            System.out.println("Sorry, you did not guess correctly");
        }
        System.out.println("The answer was " + board.getWord());
        input.close();
        reader.close();
    }
}