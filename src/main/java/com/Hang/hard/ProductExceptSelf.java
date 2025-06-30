package com.Hang.hard;

import java.util.Arrays;
import java.util.Scanner;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int preP = 1, lastP = 1;
        int[] ans = new int[n];
        Arrays.fill(ans,1);

        while(l < n){
            ans[l] *= preP;
            ans[r] *= lastP;
            preP *= nums[l];
            lastP *= nums[r];
            l++;
            r--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.substring(1, str.length() - 1).split(",\\s*");
        int[] nums = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        int[] res = productExceptSelf(nums);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + ",");
        }
    }
}
