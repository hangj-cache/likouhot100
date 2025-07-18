package com.Hang.Second;

import java.util.Scanner;

public class ReverseList {


    private static Node reverseList(Node head) {
        Node cur = head;
        Node ptr = null;
        Node aft = cur.next;
        while(cur != null) {
            cur.next = ptr;
            ptr = cur;
            cur = aft;
            if(cur != null) {
                aft = cur.next;
            }

        }
        return ptr;
    }

    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = str.substring(1, str.length() - 1).split(",\\s*");
        int[] nums = new int[ss.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(ss[i]);
        }
        // 构建链表
        Node head = buildList(nums);
        // 反转链表
        Node res = reverseList(head);
        while (res != null){
            System.out.print(res.val);

            if(res.next != null){
                System.out.print(",");
            }
            res = res.next;
        }

    }


    private static Node buildList(int[] nums){
        Node dummyHead = new Node(-1);
        Node cur = dummyHead;
        for(int i = 0; i < nums.length; i++){
            cur.next = new Node(nums[i]);
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
