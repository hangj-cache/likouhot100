package com.Hang;

import java.util.Scanner;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * [[1,1,1],[1,0,1],[1,1,1]]
 */
public class SetZeros {

    public static void setZero(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstRow = false, firstCol = false;

        for(int i = 0; i < n; i++){
            if(matrix[i][0] == 0){
                firstRow = true;
            }
        }

        for(int j = 0; j < m; j++){
            if(matrix[0][j] == 0){
                firstCol = true;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < m; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0; j < m; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < n; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRow){
            for(int j = 0; j < m; j++){
                matrix[0][j] = 0;
            }
        }
        if(firstCol){
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }



    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.substring(2,str.length()- 2).split("\\],\\[");
        int[][] matrix = new int[strs.length][];

        for(int i = 0; i < strs.length; i++){
            String[] ss = strs[i].split(",");
            int[] row = new int[ss.length];
            for(int j = 0; j < ss.length; j++){
                row[j] = Integer.parseInt(ss[j]);
            }
            matrix[i] = row;
        }
        setZero(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
