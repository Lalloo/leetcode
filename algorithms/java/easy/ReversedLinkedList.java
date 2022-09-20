package easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReversedLinkedList {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReversedLinkedList.class);

    public static void main(String[] args) {
        var listNode1 = new ListNode(5, null);
        var listNode2 = new ListNode(4, listNode1);
        var listNode3 = new ListNode(3, listNode2);

        var listNode4 = new ListNode(2, listNode3);
        var listNode5 = new ListNode(1, listNode4);

        var output = new ReversedLinkedList().iterative(listNode5);
        while (output != null) {
            LOGGER.info("{} ", output.val);
            output = output.next;
        }
    }

    public static class ListNode {
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

    public ListNode iterative(ListNode head) {
        if (head == null) {
            return null;
        }

        var reversed = new ListNode(head.val);
        ListNode newHead;

        while (head.next != null) {
            newHead = new ListNode(head.next.val);
            newHead.next = reversed;
            reversed = newHead;
            head = head.next;
        }
        return reversed;
    }

    public ListNode recursive(ListNode head) {
        if (head == null || head.next == null)
            return head;
        var reversed = recursive(head.next);
        head.next.next = head;
        head.next = null;

        return reversed;
    }
}
