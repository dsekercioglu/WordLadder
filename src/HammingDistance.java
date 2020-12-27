import java.util.stream.IntStream;

public class HammingDistance implements EditDistance {

	//Number of substitutions
	@Override
	public int computeDistance(String word1, String word2) {
		/*
		if (word1.length() != word2.length()) {
			throw new IllegalArgumentException("Strings must have the same number of characters");
		}
		 */
		return (int) IntStream.range(0, word1.length()).filter(i -> word1.charAt(i) != word2.charAt(i)).count();
	}

	@Override
	public boolean areSimilar(String word1, String word2, int threshold) {
		//return computeDistance(word1, word2) < threshold;
		if (word1.length() != word2.length()) {
			return false;
		}
		int distance = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				distance++;
			}
			if (distance >= threshold) {
				return false;
			}
		}
		return true;
	}
}
