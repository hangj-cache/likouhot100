package com.Hang.hard;

import java.util.Scanner;

/**
 * 不难，但是妙
 */
public class Rotate {

    public static void rotate(int[] nums, int k) {
        if(k > nums.length){
            k = k % nums.length;
        }

        reverse(nums, 0, nums.length - 1);  // 注意注意，一定先整体翻转，然后分段翻转，否则错
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public static void reverse(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();

        String[] strs = str.substring(1, str.length() - 1).split(",\\s*");
        int[] nums = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            nums[i] = Integer.parseInt(strs[i]);
        }

        rotate(nums,k);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + ",");
        }

    }
}
