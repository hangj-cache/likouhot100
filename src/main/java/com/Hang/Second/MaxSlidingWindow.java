package com.Hang.Second;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] != b[0]? b[0] - a[0]: b[1] - a[1]);
        int[] ans = new int[n - k + 1];
//        for(int i = 0; i < k; i++){
//            pq.offer(new int[]{nums[i],i});
//        }
//        ans[0] = pq.peek()[0];
        for(int i = 0; i < n; i++){
            pq.offer(new int[]{nums[i],i});
            while(pq.peek()[1] < i - k + 1){
                pq.poll();
            }
            if(i >= k - 1){
                ans[i-k+1] = pq.peek()[0];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] ss = str.substring(1, str.length() - 1).split(",\\s*");
        int[] nums = new int[ss.length];
        for(int i = 0; i < ss.length; i++){
            nums[i] = Integer.parseInt(ss[i]);
        }

        int[] res = maxSlidingWindow(nums, k);
        System.out.print("[");
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i]);
            if(i != res.length - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");

    }
}
