package anagramma.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class Dizionario extends TreeSet<String> {
    
	private String fileName;
	public Dizionario(String fileName) throws IOException {
		this.fileName=fileName;
		load(fileName);
	}
	private void load(String fileName) throws IOException {
		BufferedReader bf=new BufferedReader( new FileReader(fileName));
		String line;
		while ((line=bf.readLine())!=null) {
			this.add(line);
		}
		bf.close();
	}
	
}
