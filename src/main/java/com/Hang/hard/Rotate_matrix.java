package com.Hang.hard;


import java.util.Scanner;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class Rotate_matrix {

    public static void rotate(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < m / 2; i++){
            for(int j = 0; j < (n+1) / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m-j-1][i];
                matrix[m-j-1][i] = matrix[n-i-1][m-j-1];
                matrix[n-i-1][m-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }


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

        rotate(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
