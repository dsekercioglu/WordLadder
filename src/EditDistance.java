public interface EditDistance {

	/*
	Other distances can be added
	Levenshtein distance
	Longest Common Subsequence distance
	etc.
	 */
	int computeDistance(String word1, String word2);

	boolean areSimilar(String word1, String word2, int threshold);
}
