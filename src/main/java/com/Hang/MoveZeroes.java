package com.Hang;

import java.util.Scanner;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                swap(nums,l,r); // 只要当r下标指向元素不为0就进行交换
                l++;
            }
            r++;
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] strs = str.substring(1, str.length() - 1).split(",\\s*");

        int[] nums = new int[strs.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(strs[i]);
        }

        moveZeroes(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }

    }
}
