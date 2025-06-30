package com.Hang.hard;


/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 子数组的和相关---统一前缀和
 */
public class SubarraySum {
    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        int lPre = 0;
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < n; i++) {
            lPre += nums[i];
            if(map.containsKey(lPre - k)){
                ans += map.get(lPre - k);
            }
            map.put(lPre, map.getOrDefault(lPre, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        String[] strs = str.substring(1,str.length()-1).split(",\\s*");
        int[] nums = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(subarraySum(nums, k));
    }
}
