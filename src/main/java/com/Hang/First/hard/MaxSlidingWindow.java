package com.Hang.First.hard;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 优先队列
 * 注意要完成这题：不能严格要求队列中元素的数量，需要用一个数组同时记住元素和下标，然后对于出队列只需要判断poll出去的那个最大的是不是在范围内
 * ！！！不用严格要求队列中元素的数量
 */
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0){
            return new int[0];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] != b[0] ? b[0]-a[0]: b[1]-a[1]);
        int[] res = new int[n - k + 1];
        for(int i = 0; i < k; i++){
            pq.offer(new int[]{nums[i],i});
        }
        res[0] = pq.peek()[0];

        for(int i = k; i < n; i++){
            pq.offer(new int[]{nums[i],i});
            while(pq.peek()[1] < i - k + 1){
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] strs = str.substring(1, str.length()- 1).split(",\\s*");
        int[] nums = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            nums[i] = Integer.parseInt(strs[i]);
        }

        int[] res = maxSlidingWindow(nums, k);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }

    }
}
