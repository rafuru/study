package dev.rcarrillo.ctci.arrays;

import java.util.Objects;

/**
 * There are three types of edits on a String: insert, remove, replace (characters).
 * Given two strings write a function to check if they are one (or zero) edit away
 */
public class OneWay {

    public static void main(String[] args) {
        //expected : true
        System.out.println(checkSingleEdit("rafuru","rafuru"));
        //expected : true
        System.out.println(checkSingleEdit("rafuru","rafuru1"));
        //expected : true
        System.out.println(checkSingleEdit("rafuru1","rafuru"));
        //expected : false
        System.out.println(checkSingleEdit("rafuru","rafuru11"));
        //expected : false
        System.out.println(checkSingleEdit("rafuru11","rafuru"));
        //expected : false
        System.out.println(checkSingleEdit("rasfru","rafuru"));
        //expected : false
        System.out.println(checkSingleEdit("rafuru","reauru"));
    }

    private static boolean checkSingleEdit(String string1, String string2) {
        //mandatory nullchecks
        Objects.requireNonNull(string1, "String 1 is null");
        Objects.requireNonNull(string2, "String 2 is null");
        // determine longest string:
        int diffStrings = string1.length() - string2.length();
        if(diffStrings > 1 || diffStrings < -1){
            return false;
        }
        char [] longestStr = diffStrings >=0 ? string1.toCharArray() : string2.toCharArray() ;
        char [] shortestStr = diffStrings <0 ? string1.toCharArray() : string2.toCharArray();

        //check lengths
        int diffCount = 0;
        for(int i = 0; i<shortestStr.length; i++){
            if(shortestStr[i] != longestStr[i]){
                diffCount +=1;
            }
            if(diffCount>1){
                return false;
            }
        }

        return true;
    }

}