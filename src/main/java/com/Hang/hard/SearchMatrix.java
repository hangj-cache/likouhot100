package com.Hang.hard;

import java.util.Scanner;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 肯定也是要两层循环的，只是可以跳过一部分元素的检索
 */
public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = m - 1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                if(matrix[j][i] == target){
                    return true;
                }else if(matrix[j][i] > target){
                    break;
                }else{
                    continue;
                }
            }
        }
        return false;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int target = sc.nextInt();

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

        boolean ans = searchMatrix(matrix, target);
        System.out.println(ans);


    }
}
