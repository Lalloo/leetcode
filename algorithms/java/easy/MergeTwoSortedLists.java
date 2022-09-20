package easy;


public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode firstListNode1 = new ListNode(4, null);
        ListNode firstListNode2 = new ListNode(2, firstListNode1);
        ListNode firstListNode3 = new ListNode(1, firstListNode2);

        ListNode secondListNode1 = new ListNode(4, null);
        ListNode secondListNode2 = new ListNode(3, secondListNode1);
        ListNode secondListNode3 = new ListNode(1, secondListNode2);

        ListNode output = new MergeTwoSortedLists().mergeTwoLists(firstListNode3, secondListNode3);
        while (output != null) {
            System.out.printf("%d ", output.val);
            output = output.next;
        }
    }

    static class ListNode {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode p = head;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                p.next = list2;
                list2 = list2.next;
            } else {
                p.next = list1;
                list1 = list1.next;
            }
            p = p.next;
        }
        if (list1 != null) {
            p.next = list1;
        } else {
            p.next = list2;
        }
        return head.next;
    }
}

