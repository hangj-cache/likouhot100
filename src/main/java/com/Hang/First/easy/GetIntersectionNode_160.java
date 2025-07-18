package com.Hang.First.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GetIntersectionNode_160 {

    // 节点类一般作为静态内部类   普通非静态内部类在 static 方法中是无法直接使用的。
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public static Node getIntersectionNode(Node headA, Node headB) {
        Set<Node> set = new HashSet<>();
        Node curA = headA;
        while(curA != null){
            set.add(curA);
            curA = curA.next;
        }

        Node curB = headB;
        while(curB != null){
            if(set.contains(curB)){
                return curB;
            }
            curB = curB.next;
        }
        return null;

    }

    public static void main(String[] args) {
        // 首先自己构造链表
        Scanner sc = new Scanner(System.in);
        // intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
        int intersectVal = sc.nextInt();
        sc.nextLine();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int skipA = sc.nextInt();
        int skipB = sc.nextInt();

        int n = str1.length();
        int m = str2.length();
        String[] ss1 = str1.substring(1, n - 1).split(",\\s*");
        String[] ss2 = str2.substring(1,m-1).split(",\\s*");
        int[] nums1 = new int[ss1.length];
        int[] nums2 = new int[ss2.length];
        for(int i = 0; i < ss1.length; i++){
            nums1[i] = Integer.parseInt(ss1[i]);
        }

        for(int i = 0; i < ss2.length; i++){
            nums2[i] = Integer.parseInt(ss2[i]);
        }

        Node headA = buildList(nums1);
        Node headB = null;
        if(intersectVal != 0){
            headB = combineList(headA, nums2, intersectVal, skipA, skipB);
        }else{
            headB = buildList(nums2);
        }

        Node intersectionNode = getIntersectionNode(headA, headB);
        if(intersectionNode == null){
            System.out.println("没有相交节点");
        }else{
            System.out.println("相交节点的值为：" + intersectionNode.val);
        }


    }

    private static Node combineList(Node headA, int[] nums, int intersectVal, int skipA, int skipB){
        int n = nums.length;
        Node curA = headA;
        while(curA != null){
            curA = curA.next;
            skipA--;
            if(skipA == 0){
                break;
            }
        }
        Node dummyNodeB = new Node(-1);
        Node curB = dummyNodeB;
        for(int i = 0; i < n; i++){
            curB.next = new Node(nums[i]);
            curB = curB.next;
            skipB--;
            if(skipB == 0){
                break;
            }
        }
        curB.next = curA;


        return dummyNodeB.next;
    }

    private static Node buildList(int[] nums) {

        Node dummyHead = new Node(-1);
        Node cur  = dummyHead;
        for(int i = 0; i < nums.length; i++){
            cur.next = new Node(nums[i]);
            cur = cur.next;
        }
        return dummyHead.next;
    }


}
