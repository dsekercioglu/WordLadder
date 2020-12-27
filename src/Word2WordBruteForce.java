import java.util.ArrayList;
import java.util.HashSet;

public class Word2WordBruteForce {

	private final EditDistance DISTANCE;
	private final int THRESHOLD;
	private final HashSet<String> WORDS;

	public Word2WordBruteForce(EditDistance distance, int threshold, HashSet<String> words) {
		DISTANCE = distance;
		THRESHOLD = threshold;
		WORDS = words;
	}

	public void find(String start, String end, int maxDepth) {
		discover(start, end, new ArrayList<>(), -1, maxDepth);
	}


	private void discover(String start, String end, ArrayList<String> strings, int lastChange, int maxDepth) {
		strings.add(start);
		for (int i = 0; i < start.length(); i++) {
			for (char c = 'A'; c <= 'Z'; c++) {
				if (lastChange != i) {
					String newWord = start.substring(0, i) + c + start.substring(i + 1);
					if (!newWord.equals(start)) {
						if (DISTANCE.areSimilar(newWord, end, THRESHOLD)) {
							System.out.println();
							for (String string : strings) {
								System.out.println(string);
							}
							System.out.println(end);
						}
						if (maxDepth > 1 && WORDS.contains(newWord)) {
							discover(newWord, end, (ArrayList<String>) strings.clone(), i, maxDepth - 1);
						}
					}
				}
			}
		}
	}
}
