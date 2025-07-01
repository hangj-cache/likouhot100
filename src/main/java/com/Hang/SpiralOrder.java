package com.Hang;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * [[1,2,3],[4,5,6],[7,8,9]]
 */
public class SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0, r = m - 1, t = 0, b = n - 1;
        while(l <= r && t <= m) {
            for(int i = l; i <= r; i++){
                res.add(matrix[t][i]);
            }

            t++;
            for(int j = t; j <= b; j++){
                res.add(matrix[j][r]);
            }
            r--;
            for(int i = r; i >= l; i--){
                res.add(matrix[b][i]);
            }
            b--;
            for(int j = b; j>= t; j--){
                res.add(matrix[j][l]);
            }
            l++;
        }

        return res;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] strs = str.substring(2,str.length() - 2).split("\\],\\[");
        int[][] matrix = new int[strs.length][];

        for(int i = 0; i < strs.length; i++){
            String[] ss = strs[i].split(",");
            int[] arr = new int[ss.length];
            for(int j = 0; j < ss.length; j++){
                arr[j] = Integer.parseInt(ss[j]);
            }
            matrix[i] = arr;
        }

        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
    }
}
