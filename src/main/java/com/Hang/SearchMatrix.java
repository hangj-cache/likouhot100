package com.Hang;

import java.util.Scanner;

public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {



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
