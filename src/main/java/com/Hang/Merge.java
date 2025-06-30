package com.Hang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Merge {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        int n = intervals.length;
        for(int i = 0; i < n; i++) {
            if(res.size() == 0 || res.get(res.size() - 1)[1] < intervals[i][0]){
                res.add(intervals[i]);
            }
            int[] temp = res.get(res.size() - 1);
            if(temp[1] >= intervals[i][0] && temp[1] < intervals[i][1]){
                temp[1] = intervals[i][1];
            }
        }
        int[][] ans = new int[res.size()][];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.substring(2,str.length()-2).split("\\],\\[");

        int[][] intervals = new int[strs.length][];
        for(int i = 0; i < strs.length; i++){
            String[] ss = strs[i].split(",\\s*");
            int[] arr = new int[ss.length];
            for(int j = 0; j < ss.length; j++){
                arr[j] = Integer.parseInt(ss[j]);
            }
            intervals[i] = arr;
        }
        int[][] ans = merge(intervals);
        for(int i = 0; i < ans.length; i++){
            System.out.print("[");
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + ",");
            }
            System.out.print("]");
        }
    }
}
