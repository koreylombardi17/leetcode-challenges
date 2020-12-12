package medium;

public class AddTwoNumbers {

//    You are given two non-empty linked lists representing two non-negative integers.
//    The digits are stored in reverse order, and each of their nodes contains a single digit.
//    Add the two numbers and return the sum as a linked list.
//
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode list1 = l1, list2 = l2, lSum = head;
        int val1 = 0, val2 = 0, sum = 0, carry = 0;

        while (list1 != null || list2 != null) {
            if (list1 != null) {
                val1 = list1.val;
                list1 = list1.next;
            } else {
                val1 = 0;
            }

            if (list2 != null) {
                val2 = list2.val;
                list2 = list2.next;
            } else {
                val2 = 0;
            }

            sum = val1 + val2 + carry;
            carry = sum / 10;
            lSum.next = new ListNode(sum % 10);
            lSum = lSum.next;
        }
        return head.next;
    }

    // Definition for singly-linked list.
    class ListNode {

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
