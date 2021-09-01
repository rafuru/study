package dev.rcarrillo.ctci.arrays;

/**
 * Implement an algorithm to determine if a string has all unique characteres. What if you can't use additional structures
 */
public class IsUnique {

    public static void main(String[] args) {
        String word = "nn";
        boolean isUnique = isUnique(word);
        System.out.println(isUnique); //expected true
    }

    private static boolean isUnique(String word) {
        // Ask if the string is ASCII or unicode
        // Ask if the blank counts as true
        // Ask if caps counts as unique or the string should be normalized
        if (word.isBlank()) {
            return true;
        }
        word = word.toLowerCase();
        boolean[] charset = new boolean[128]; //ascii charset
        for(int i = 0; i < word.length(); i++){
            int cInt = word.charAt(i);
            if(charset[cInt]){
                return false;
            }
            charset[cInt] = true;
        }
        return true;
    }
}


