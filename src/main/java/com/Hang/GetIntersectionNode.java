package com.Hang;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */

public class GetIntersectionNode {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        Set<ListNode> set = new HashSet<>();
        while(pa != null){
            set.add(pa);
            pa = pa.next;
        }

        while(pb != null){
            if(set.contains(pb)){
                return pb;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strA = sc.nextLine();
        sc.nextLine();
        String strB = sc.nextLine();

        String[] strAs = strA.substring(1,strA.length()-1).split(",\\s*");
        String[] strBs = strB.substring(1,strB.length()-1).split(",\\s*");
        int[] numsA = new int[strAs.length];
        int[] numsB = new int[strBs.length];

    }
}
