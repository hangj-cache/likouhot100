package com.Hang;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        int maxLen = 1;
        Set<Integer> set = new HashSet<>();
        if(nums.length == 0){
            return 0;
        }
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int n = set.size();
        for(int num : set){
            int Len = 1;
            if(set.contains(num - 1)){
                continue;
            }
            while(set.contains(num+1)){
                num++;
                Len++;
            }
            maxLen = Math.max(maxLen,Len);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] strs = str.substring(1,str.length() - 1).split(",");
        int[] nums = new int[strs.length];
        for(int i = 0; i < strs.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }

        int ans = longestConsecutive(nums);
        System.out.println(ans);
    }

}
