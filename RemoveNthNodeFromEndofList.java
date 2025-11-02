/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        int length = length(head), index = 0;
        ListNode ref = head, prev = head;
        while (index != length - n) {
            index++;
            prev = ref;
            ref = ref.next;
        }
        if(index == 0) head = head.next;
        else prev.next = ref.next;

        return head;
    }

    public static int length(ListNode head) {
        int result = 0;
        ListNode ref = head;
        while (ref != null) {
            result++;
            ref = ref.next;
        }
        return result;
    }
}