package build;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringMatchingAlgorithm {
    private static final int ALPHABET_SIZE = 256;    

    public static searchPair search(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;

        int[] badChar = new int[ALPHABET_SIZE];

        // Preprocessing bad character array
        badCharHeuristic(pattern, m, badChar);

        int s = 0; // Shift of the pattern with respect to text
        List<Integer> indices = new ArrayList<>();
        int count = 0;

        while (s <= (n - m)) {
            int j = m - 1;

            // Keep reducing index j of pattern while characters of pattern and text are
            // matching at this shift s
            while (j >= 0 && pattern[j] == text[s + j]) {
                j--;
            }

            // If the pattern is present at the current shift, then add the starting
            // index to the list and increase the counter
            if (j < 0) {
                indices.add(s);
                count++;

                s += (s + m < n) ? m - badChar[text[s + m]] : 1;
            } else {
                // Shift the pattern so that the bad character in text aligns with the last
                // occurrence of it in pattern
                s += Math.max(1, j - badChar[text[s + j]]);
            }
        }

        return new searchPair(indices, count); // Return the list of indices and the count

    }

    private static void badCharHeuristic(char[] pattern, int m, int[] badChar) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            badChar[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            badChar[pattern[i]] = i;
        }
    }
}
