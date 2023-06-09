package com.ps.at.util;

public class StringUtil {

    public static String repeat(String str, int times) {

        if (times < 0) {
            throw new IllegalArgumentException();
        }

        String result = "";

        for (int i = 0; i < times; i++) {
            result += str;
        }

        return result;
    }

    public static boolean isEmpty(String str){
        return str == null || str.trim().isEmpty();

        /*if (str == null) {
            return true;
        }
        if (str.trim().isEmpty()){
            return true;
        }
        return false;*/
    }
}
