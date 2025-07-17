package com.Hang.Second;

import java.util.Scanner;

public class MaxSubArray {

    public static int maxSubArray(int[] arr){


        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i = 0; i < n; i++){
            curSum += arr[i];
            if(curSum < 0){
                curSum = 0;
            }
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = str.substring(1, str.length() - 1).split(",\\s*");
        int[] arr = new int[ss.length];
        for(int i = 0; i < ss.length; i++){
            arr[i] = Integer.parseInt(ss[i]);
        }

        int res = maxSubArray(arr);
        System.out.println(res);
    }
}
