package com.Hang.Second;

import java.util.Scanner;

public class IsPalindrome_234 {

    static class Node{
        int val;
        Node next;
        Node(int val){  // 不加public 就是默认的范围，就是本类或者本包下可以访问
            this.val = val;
        }
    }

    private static boolean isPalindrome(Node head){
        // 法一：直接全部记录下来，然后在数组中进行判断
        // 法二：快慢指针+反转链表，找到后半链表，然后对后半链表进行反转，进行判断，最后恢复链表
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){ // 说明是奇数节点-slow处于中间节点，这里直接跳过中间节点，始终指向后半链表的开始节点
            slow = slow.next;
        }
        // 此时slow为后半部分链表开头的位置
        Node mh = reverseList(slow);
        Node mh2 = mh;

        boolean flag = true;
        Node cur = head;
        while(cur != null && mh != null){
            if(cur.val != mh.val){
                flag = false;
            }
            cur = cur.next;
            mh = mh.next;
        }
        Node node = reverseList(mh2);
        Node n = head;
        while(n.next != node){
            n = n.next;
        }
        n.next = node;
        return flag;
    }

    private static Node reverseList(Node head){
        Node ptr = null;
        Node cur = head;
        while(cur != null){
            Node aft = cur.next;
            cur.next = ptr;
            ptr = cur;
            cur = aft;
        }
        return ptr;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = str.substring(1, str.length() - 1).split(",\\s*");
        int[] nums = new int[ss.length];
        for(int i = 0; i < ss.length; i++){
            nums[i] = Integer.parseInt(ss[i]);
        }

        Node head = buildList(nums);

        boolean res = isPalindrome(head);
        if(res){
            System.out.println("是回文链表");
        }else{
            System.out.println("不是回文链表");
        }

        Node cur = head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

    }

    private static Node buildList(int[] nums){
        Node dummyHead = new Node(-1);
        Node cur = dummyHead;
        for(int i = 0; i <nums.length; i++){
            cur.next = new Node(nums[i]);
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
