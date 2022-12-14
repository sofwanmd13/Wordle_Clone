import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReadSortWrite {

	public static void main(String[] args) throws Exception{
		String word;
		List<String> list = new ArrayList<String>();
		File wordlist = new File("C:\\Users\\Sofwan Mohammed\\Desktop\\Projects\\Wordle_clone\\unsorted wordle list.txt");
		BufferedReader reader = new BufferedReader(new FileReader(wordlist));
		
		FileWriter updated = new FileWriter("C:\\Users\\Sofwan Mohammed\\Desktop\\Projects\\Wordle_clone\\sorted wordle list.txt");
		
		while((word=reader.readLine()) != null) {
			list.add(word);
		}
		
		Collections.sort(list);
		
		for(int i =0; i<list.size(); i++) {
			updated.write(list.get(i)+"\n");
		}
		
		reader.close();
		updated.close();
	}

}