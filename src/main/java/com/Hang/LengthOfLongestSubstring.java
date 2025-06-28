package com.Hang;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0, curLen = 0;
        Set<Character> set = new HashSet<>();

        for(int l = 0, r = 0; r < n; r++) {
            char c = s.charAt(r);
            while(l < r && set.contains(c)){
                set.remove(s.charAt(l));
                l++;
                curLen--;
            }
            set.add(c);
            curLen++;
            maxLen = Math.max(maxLen,curLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);
    }
}
