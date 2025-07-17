package com.Hang.常考题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int maxLen = 0;
        for(int l = 0, r = 0; r < n; r++){
            char ch = s.charAt(r);
            while(l <= r && set.contains(ch)){
                set.remove(s.charAt(l));
                l++;
            }
            maxLen = Math.max(maxLen ,r - l + 1);
            set.add(ch);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans = lengthOfLongestSubstring(str);
        System.out.println(ans);

    }
}
