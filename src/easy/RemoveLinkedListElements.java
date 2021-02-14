package easy;

public class RemoveLinkedListElements {

    // Remove all elements from a linked list of integers that have value val.

    // Definition for singly-linked list.
    public class ListNode {

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

    public ListNode removeElements(ListNode head, int val) {

        // Node used to iterate through all nodes in linked list
        ListNode current = head;
        ListNode prev = null;

        // Iterate through linked list
        while (current != null) {

            // Current node needs to be removed
            if (current.val == val) {

                // Case: First node in list
                if (prev == null){
                    head = current.next;
                    current = head;
                    continue;
                }
                // Case: Last node in list
                else if (current.next == null) {
                    prev.next = null;
                    current = null;
                    continue;
                }
                // Update previous node to point to current node's next node
                else {
                    prev.next = current.next;
                    current = current.next;
                    continue;
                }

            }

            // Previous node becomes current node, and current node becomes current node's next node
            prev = current;
            current = current.next;
        }

        // Return head node
        return head;
    }
}
