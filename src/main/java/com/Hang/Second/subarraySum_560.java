package com.Hang.Second;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class subarraySum_560 {

    public static int subarraySum(int[] nums, int K) {


        int count = 0;
        int preSum = 0;
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        for(int i = 0; i < n; i++){
            preSum += nums[i];
            if(map.containsKey(preSum - K)){
                count++;
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }







    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] ss = str.substring(1, str.length() - 1).split(",");
        int[] nums = new int[ss.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(ss[i]);
        }

        int ans = subarraySum(nums, k);
        System.out.println(ans);

    }

}
