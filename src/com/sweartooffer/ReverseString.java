package com.sweartooffer;

import java.util.Arrays;

public class ReverseString {

    public static void reverseString(char[] s) {

        int i = 0, j = s.length - 1;
        char tmp;

        while (i < j) {
            tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
            i++;
            j--;
        }
        System.out.println(s);
    }

}
