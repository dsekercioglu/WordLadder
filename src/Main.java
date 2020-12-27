import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		HashSet<String> words = new HashSet<>();
		try (BufferedReader br = new BufferedReader(new FileReader("words_alpha.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				words.add(line.toUpperCase());
			}

			Scanner scn = new Scanner(System.in);
			System.out.println("enter the starting word (e.g. SHIP):");
			String start = scn.nextLine().trim().toUpperCase();
			System.out.println("enter the target word of the same length (e.g. DOCK):");
			String end = scn.nextLine().trim().toUpperCase();
			System.out.println("enter the number of steps (e.g. 5):");
			int depth = scn.nextInt();

			Word2WordBruteForce w2wbf = new Word2WordBruteForce(new HammingDistance(), 1, words);
			w2wbf.find(start, end, depth);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
