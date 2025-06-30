package com.Hang;

import java.util.Scanner;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组是数组中的一个连续部分。
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        // 其实就是如果前面的子数组和小于0，就踢掉，因为这一定是对后面的子数组和是有损害的
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum,sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] strs = str.substring(1,str.length() - 1).split(",\\s*");
        int[] nums = new int[strs.length];

        for(int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        int ans = maxSubArray(nums);
        System.out.println(ans);
    }
}
