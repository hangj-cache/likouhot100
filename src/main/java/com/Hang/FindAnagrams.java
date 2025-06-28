package com.Hang;

import java.util.*;

/**
 * 法一：数组的方法已经在力扣上写过了，这里用集合的方式来写，更符合我的思维-----说实话用数组是最简单的
 *
 * 字符串元素可能重复，因此不能直接用list集合，用hashmap可以  ,找到字符串中所有字母异位词题目：一定不能用list集合
 */
public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        Map<Character,Integer> ptemp = new HashMap<>();
        Map<Character,Integer> stemp = new HashMap<>();
        int pLen = p.length();
        int sLen = s.length();
        for(int i = 0; i < pLen; i++){
            ptemp.put(p.charAt(i),ptemp.getOrDefault(p.charAt(i),0)+1);
            stemp.put(s.charAt(i),stemp.getOrDefault(s.charAt(i),0)+1);
        }
        if(psEqual(ptemp, stemp)){
            ans.add(0);
        }

        for(int i = pLen; i < sLen; i++){
            char ch = s.charAt(i);
            stemp.put(ch,stemp.getOrDefault(ch,0) + 1);
            stemp.put(s.charAt(i - pLen),stemp.getOrDefault(s.charAt(i - pLen),0)-1);
            if(stemp.get(s.charAt(i - pLen)) == 0){
                stemp.remove(s.charAt(i - pLen));
            }
            if(psEqual(stemp,ptemp)){
                ans.add(i - pLen + 1);
            }
        }
        return ans;
    }

    private static boolean psEqual(Map<Character,Integer> stemp, Map<Character,Integer> ptemp){ // 元素可能重复，不行
        if(stemp.size() != ptemp.size()) return false;
        for(Map.Entry<Character,Integer> entry : stemp.entrySet()){
            if(!ptemp.containsKey(entry.getKey()) || entry.getValue() != ptemp.get(entry.getKey())) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();

        List<Integer> ans = findAnagrams(s, p);
        System.out.println(ans);

    }
}
