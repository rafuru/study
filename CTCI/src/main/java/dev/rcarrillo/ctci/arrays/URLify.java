package dev.rcarrillo.ctci.arrays;

import java.util.Objects;

/**
 * Create a method to replace the spaces with %20
 */
public class URLify {

    public static void main(String[] args) {
        String url = "http://rcarrillo.dev/my  space";

        // expected http://rcarrillo.dev/my%20%20space;
        System.out.println(urlify(url));
    }

    private static String urlify(String url) {
        if(Objects.isNull(url)){
            throw new RuntimeException("Invalid URL");
        }

        int newLength = url.length();
        for(int i=0 ; i < url.length() ; i++){
            if(url.charAt(i)==' '){
                newLength+=2; //%20
            }
        }

        char[] urlArr = new char[newLength];
        int originalPosFlag = 0;
        for(int i=0 ; i < urlArr.length ; i++){
            if(url.charAt(originalPosFlag)==' '){
                urlArr[i] = '%';
                i+=1;
                urlArr[i] = '2';
                i+=1;
                urlArr[i] = '0';
            }else{
                urlArr[i]=url.charAt(originalPosFlag);
            }
            originalPosFlag+=1;
        }

        return new String(urlArr);
    }
}
