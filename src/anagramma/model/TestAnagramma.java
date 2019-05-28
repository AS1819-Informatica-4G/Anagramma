package anagramma.model;

public class TestAnagramma {

	public TestAnagramma() {
		
	}

public static void main(String[] args) {
	long startTime = System.nanoTime();
	Anagramma ana=new Anagramma("aa");
	long endTime = System.nanoTime();
	ana.getSequenze().forEach(s->System.out.println(s));
	int nSeq=ana.getSequenze().size();
	System.out.println("Totale "+ nSeq+ ((nSeq==1) ? " sequenza" : " sequenze"));

	long timeElapsed = endTime - startTime;

	System.out.println("Execution time in nanoseconds  : " + timeElapsed);

	System.out.println("Execution time in milliseconds : " + 
							timeElapsed / 1000000);
}
}
