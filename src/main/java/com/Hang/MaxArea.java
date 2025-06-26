package com.Hang;

import java.util.Scanner;

public class MaxArea {

    public static int maxArea(int[] height){
        int n = height.length;
        int l = 0, r = n - 1;
        int maxA = 0, curA = 0;
        while(l < r){
            curA = (r - l) * Math.min(height[l], height[r]);
            maxA = Math.max(maxA,curA);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }

        return maxA;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.substring(1,str.length()-1).split(",\\s*");
        int[] nums = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            nums[i] = Integer.parseInt(strs[i]);
        }

        int ans = maxArea(nums);
        System.out.println(ans);
    }
}
