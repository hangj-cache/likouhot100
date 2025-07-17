package com.Hang.First.easy;

import java.util.Scanner;
import java.util.Stack;

public class Trap {
    public static int trap(int[] height){
        // 单调栈----单调栈存的是索引
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int bottom = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                sum += (Math.min(height[left],height[i]) - height[bottom]) * (i - left - 1);
            }
            stack.push(i);

        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.substring(1, str.length() - 1).split(",\\s*");
        int[] height = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            height[i] = Integer.parseInt(strs[i]);
        }

        int ans = trap(height);
        System.out.println(ans);
    }
}
