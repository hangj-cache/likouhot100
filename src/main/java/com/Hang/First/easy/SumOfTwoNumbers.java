package com.Hang.First.easy;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 */
public class SumOfTwoNumbers {
    public static int[] sumOfTwoNumbers(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(target - num)){
                return new int[]{num,target - num};
            }
            set.add(num);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt(); // 这里是读取一个数字
        sc.nextLine(); // 这是消耗掉一个回车，否则这个回车回当作下一行的输入，直接返回的
        String str = sc.nextLine();
        int n = str.length();
        String[] strs = str.substring(1,n-1).split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        int[] ans = sumOfTwoNumbers(nums, target);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }

}
