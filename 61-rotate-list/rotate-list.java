
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and tail
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Reduce rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Make circular list
        tail.next = head;

        // Find new tail
        int stepsToNewTail = length - k;
        ListNode newTail = tail;

        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }

        // Break circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
