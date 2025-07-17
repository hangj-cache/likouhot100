package com.Hang.First.easy;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(int i = 0;i < strs.length;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if(!map.containsKey(str)){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(str,list);
            }else{
                List<String> list = map.get(str);
                list.add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        String str_new = str.substring(2,str.length() - 2);
        String[] strs = str_new.split("\",\\s*\"");  // \s*匹配可能出现的空格

        List<List<String>> ans = groupAnagrams(strs);
        System.out.println(ans);
    }
}
