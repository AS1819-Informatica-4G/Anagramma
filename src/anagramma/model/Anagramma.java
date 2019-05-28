package anagramma.model;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Anagramma {
	char[] parola=null;
	
    private Set<String> sequenze =new TreeSet<>();
   
    private int lung;
    private int iterz;
    private Dizionario dizionario;
    
    public Anagramma( ) throws IOException {
    	dizionario= new Dizionario("mark.txt");
    }
    
	public Anagramma(String parola) {
		setParola(parola);
		processa();
	}
	
	public void setParola(String parola) {
		sequenze.clear();
		this.parola=parola.toCharArray();
		this.lung=parola.length();
	}
	
	public void processa() {
		iterz=0;
		if (parola != null )
			processa(this.parola[0],new char[0] );
	}
	
	public void processa(char e, char[] s) {
		// Spazio per la stringa + 1 carattere
		int ln=s.length+1;
		// Conto le iterazioni
		iterz++;
		// nuova sequenza + carattere 
		char[] cvet=new char[ln];
		
		for (int i=0; i<ln; i++) {
			cvet[i]=e;
			int pos=0;
			for (int j=0;j<ln;j++) {
				if (j==i) continue;
				cvet[j]=s[pos++];
			}
			if (++pos<lung) {
				// Non abbiamo raggiunto la fine delle sequenze di questo ramo
				// quindi processiamo (ricorsione)
				processa(parola[pos], cvet);
			} else {
				// Aggiungiamo la sequenza al set di sequenze
				String p=new String(cvet);
				if ( dizionario.contains(p) ) { 
					sequenze.add(p);
				}
			}
		}
	}
	
	public int getIterz() {
		return iterz;
	}

	public Set<String> getSequenze() {
		return sequenze;
	}
	
}