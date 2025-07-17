package com.Hang.First.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int num = nums[i];

            int l = i + 1, r = n - 1;
            while(l < r) {
                if(num+ nums[l] + nums[r] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]){
                        l++;
                    }

                    while(l < r && nums[r] == nums[r+1]){
                        r--;
                    }


                }else if(num+ nums[l] + nums[r] < 0) {
                    l++;
                }else{
                    r--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.substring(1, str.length() - 1).split(",\\s*");

        int[] nums = new int[strs.length];
        for(int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        List<List<Integer>> ans = threeSum(nums);

        System.out.println(ans);
    }
}
