package dev.rcarrillo.ctci.arrays;

import java.util.*;

/**
 * Given two Strings, write a method to decide if a string is a permutation of the other
 */
public class CheckPermutation {

    enum APPROACH {
        METHOD1,METHOD2
    }

    public static boolean checkPermutation(String stringA, String stringB, APPROACH approach){
        //null checks ?
        if(Objects.isNull(stringA) || Objects.isNull(stringB)){
            throw new RuntimeException ("Null string passed");
        }
        // Does white space count?
        //Ask if is case-sensitive (?)
        stringA = normalizeString(stringA);
        stringB = normalizeString(stringB);

        if(stringA.length()!=stringB.length()){
            return false;
        }
        boolean result;
        switch (approach){
            case METHOD1 -> result = approach1(stringA,stringB);
            case METHOD2 -> result = approach2(stringA,stringB);
            default -> throw new RuntimeException("invalid approach");
        }
        return result;
    }

    private static boolean approach2(String stringA, String stringB) {
        // using an array to memorize number of appearances
        int [] memoA = new int[128];
        int [] memoB = new int[128];
        for(int i = 0 ; i<stringA.length() ; i++){
            memoA[stringA.charAt(i)] = memoA[stringA.charAt(i)]+=1 ;
            memoB[stringB.charAt(i)] = memoB[stringB.charAt(i)]+=1 ;
        }
        return Arrays.equals(memoA, memoB);
    }

    private static boolean approach1(String stringA, String stringB){
        char [] charArrA = stringA.toCharArray();
        char [] charArrB = stringB.toCharArray();
        Arrays.sort(charArrA);
        Arrays.sort(charArrB);
        return Arrays.equals(charArrA, charArrB);
    }

    public static void main(String[]args){
        // Approach 1 : transform into char array, sort and compare
        System.out.println("Approach 1 : transform into char array, sort and compare");
        System.out.println(checkPermutation("AAB","ABA", APPROACH.METHOD1)); // true
        System.out.println(checkPermutation("ABC","CbA", APPROACH.METHOD1)); // true
        System.out.println(checkPermutation("XAB","ABZ", APPROACH.METHOD1)); // false

        // Approach 2 : similar to isUnique , create 128 positions int array and store the number of char appearances, then compare both arrays
        System.out.println("Approach 2 : similar to isUnique , create 128 positions int array and store the number of char appearances, then compare both arrays");
        System.out.println(checkPermutation("AAB","ABA", APPROACH.METHOD2)); // true
        System.out.println(checkPermutation("ABC","CbA", APPROACH.METHOD2)); // true
        System.out.println(checkPermutation("XAB","ABZ", APPROACH.METHOD2)); // false
        System.out.println(checkPermutation("XABACACACACACA","ABACACACACACAX", APPROACH.METHOD2)); //true
    }

    private static String normalizeString(String string){
        return string.toLowerCase().replaceAll("\\s+","");
    }
}