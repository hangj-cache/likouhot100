package com.Hang.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinWindow {
    public static String minWindow(String s,String t){
        Map<Character,Integer> sMap = new HashMap<Character,Integer>();
        Map<Character,Integer> tMap = new HashMap<Character,Integer>();

        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0) + 1);
        }

        int l = 0, r = 0;
        int minL = -1, minR = -1;
        int minLen = Integer.MAX_VALUE;

        for(; r < s.length(); r++){
            if(tMap.containsKey(s.charAt(r))){
                sMap.put(s.charAt(r),sMap.getOrDefault(s.charAt(r),0)+1);
            }

            while(l <= r && isEquals(sMap,tMap)){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    minL = l;
                    minR = r;
                }

                if(tMap.containsKey(s.charAt(l))){
                    sMap.put(s.charAt(l),sMap.get(s.charAt(l))-1);
                }

                l++;
            }
        }
        return minL == -1 ? "":s.substring(minL,minR+1);
    }

    private static boolean isEquals(Map<Character,Integer> map1,Map<Character,Integer> map2){
        for(Map.Entry<Character,Integer> entry : map2.entrySet()){
            char key = entry.getKey();
            Integer value = entry.getValue();
            if(!map1.containsKey(key) || map1.get(key) < value){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(minWindow(s, t));
    }
}
