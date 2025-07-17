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
        // 当值相等的时候一定要让索引大的在堆顶，因为我需要判断堆顶元素最大元素是否在我的窗口内，假如说选择了索引小的在堆顶，那么这时候判断这个元素的
        // 索引<i-k+1（因为我们是按照i来遍历的因此一定是<i的）那么这个元素应该被剔除，这时候就需要重新去另一个值最大元素，但是如果是索引比较大的那个，
        // 如果是索引比较大的，这个都<i-k+1的话，那么这个值一定是不符合的
        // 如果你让「索引小的排在前面」，那么：你可能会先取出一个已经过期的最大值，反而要多次 poll，效率低。
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
