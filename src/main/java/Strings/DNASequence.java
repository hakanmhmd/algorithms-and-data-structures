package Strings;

import java.util.*;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 */
public class DNASequence {
    public static void main(String[] args) {
        String seq = "ACCCTCCCACTTGGATGCCGCACGTGTCGACTAACCTTACATTGTCCCCCCACCTCCAGACGGTTAACTCTTGAAATGGGGGAATAGCTGCTTGCGCGTG";

        System.out.println(findRepeatedDnaSequences(seq));
    }

    private static final Map<Character, Integer> encodings = new HashMap<>();

    static {
        encodings.put('A',0);
        encodings.put('C',1);
        encodings.put('G',2);
        encodings.put('T',3);
    }

    private static final int A_SIZE_POW_9 = (int) Math.pow(encodings.size(), 9);
    // Rolling hash method
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<Integer> hashes = new HashSet<>();
        for (int i = 0, rhash = 0; i < s.length(); i++) {
            if (i >= 10) rhash -= A_SIZE_POW_9 * encodings.get(s.charAt(i-10));
            rhash = encodings.size() * rhash + encodings.get(s.charAt(i));
            if (i >= 9 && !hashes.add(rhash)) res.add(s.substring(i-9,i+1));
        }
        return new ArrayList<>(res);
    }


}
