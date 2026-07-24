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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        // Count total nodes
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int partSize = length / k;
        int extra = length % k;

        curr = head;

        for (int i = 0; i < k; i++) {
            if (curr == null) {
                result[i] = null;
                continue;
            }

            result[i] = curr;

            int currentPartSize = partSize + (extra > 0 ? 1 : 0);
            if (extra > 0) extra--;

            // Move to last node of current part
            for (int j = 1; j < currentPartSize; j++) {
                curr = curr.next;
            }

            // Break the list
            ListNode nextPart = curr.next;
            curr.next = null;
            curr = nextPart;
        }

        return result;
    }
}
