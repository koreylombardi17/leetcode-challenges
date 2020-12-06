package medium;

import java.math.BigInteger;

public class AddTwoNumbers {

//    You are given two non-empty linked lists representing two non-negative integers.
//    The digits are stored in reverse order, and each of their nodes contains a single digit.
//    Add the two numbers and return the sum as a linked list.
//
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String s1 = "";
        String s2 = "";

        s1 = s1 + l1.val;
        while (l1.next != null) {
            s1 = s1 + l1.next.val;
            l1 = l1.next;
        }

        s2 = s2 + l2.val;
        while (l2.next != null) {
            s2 = s2 + l2.next.val;
            l2 = l2.next;
        }

        StringBuilder sb1 = new StringBuilder();
        sb1.append(s1);
        sb1 = sb1.reverse();

        StringBuilder sb2 = new StringBuilder();
        sb2.append(s2);
        sb2 = sb2.reverse();

        s1 = sb1.toString();
        s2 = sb2.toString();

        BigInteger num1 = new BigInteger(s1);
        BigInteger num2 = new BigInteger(s2);
        BigInteger sum = num1.add(num2);

        StringBuilder sbSum = new StringBuilder();
        sbSum.append(sum);
        sbSum = sbSum.reverse();

        ListNode retList = new ListNode(Character.getNumericValue(sbSum.charAt(0)), null);
        for (int i = 1; i < sbSum.length(); i++){
            ListNode tempNode = retList;
            while(tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = new ListNode(Character.getNumericValue(sbSum.charAt(i)), null);
        }
        return retList;
    }

    // Definition for singly-linked list.
    private class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
