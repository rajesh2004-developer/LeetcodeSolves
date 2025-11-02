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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        while(set.contains(head.val)) head = head.next;
        ListNode prev = head, current = head.next;
        while(current != null) {
            if(set.contains(current.val)) {
                prev.next = current.next;
            }
            else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}