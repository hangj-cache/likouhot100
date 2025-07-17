package com.Hang.Second;

import java.util.Arrays;
import java.util.Scanner;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int lPre = 1, rPre = 1;
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);  // 因为不能乘自己位上的数，因此必须将每个位上的数都初始化为1
        int n = nums.length;
        for(int i = 0; i < nums.length; i++) {
            ans[i] = ans[i] * lPre;
            ans[n - 1 - i] = ans[n - 1 - i] * rPre;
            lPre *= nums[i];
            rPre *= nums[n - 1 - i];
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = str.substring(1, str.length() - 1).split(",\\s*");
        int[] arr = new int[ss.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(ss[i]);
        }

        int[] res = productExceptSelf(arr);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i]);
            if(i != res.length - 1){
                System.out.print(",");
            }
        }

    }
}
