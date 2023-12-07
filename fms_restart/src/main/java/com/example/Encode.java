package com.example;

public class Encode {
    private static final String code = "asdfghjkl";

    public static String encode(String input){
        String output = "";
        for(int i=1 ; i<code.length() ; i++){
            output = input.replaceAll(String.valueOf(code.charAt(i)),String.valueOf(code.charAt(i-1)));
        }
        return output;
    }
}
