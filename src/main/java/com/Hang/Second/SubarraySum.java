package com.Hang.Second;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySum {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int lP = 0;
        int n = nums.length;
        int sum = 0;
        map.put(0,1);
        for(int i = 0; i < n; i++){
            lP += nums[i];// 长前缀
            sum += map.getOrDefault(lP - k,0);
            map.put(lP,map.getOrDefault(lP,0) + 1);  // 这是将短前缀加到map集合中
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] ss = str.substring(1, str.length() - 1).split(",\\s*");
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        int res = subarraySum(arr,k);
        System.out.println(res);
    }
}
