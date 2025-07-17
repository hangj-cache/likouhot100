package com.Hang.Second;

import java.util.Scanner;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        for(int l = 0, r = 0; r < nums.length;) {
            if(nums[r] != 0){
                swap(nums,l,r);
                r++;
                l++;
            }else{
                r++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = str.substring(1,str.length()-1).split(",\\s*");

        int[] nums = new int[ss.length];
        for(int i = 0; i < ss.length; i++){
            nums[i] = Integer.parseInt(ss[i]);
        }

        moveZeroes(nums);
        for(int i = 0;i < nums.length; i++){
            System.out.print(nums[i]);
            if(i != nums.length - 1){
                System.out.print(", ");
            }
        }

    }
}
