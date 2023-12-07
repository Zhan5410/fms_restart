package com.example;

public class Decode {
    private static final String code = "lkjhgfdsa";

    public static String decode(String input){
        String output = "";
        for(int i=1 ; i<code.length() ; i++){
            output = input.replaceAll(String.valueOf(code.charAt(i)),String.valueOf(code.charAt(i-1)));
        }
        return output;
    }
}
