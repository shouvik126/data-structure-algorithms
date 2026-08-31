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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode node = head;
        ListNode prev = node;
        node = node.next;
        if (node == null || node.next == null) {
            return new int[]{-1, -1};
        }
        int pos = 1;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (node.next != null) {
            if ((node.val < prev.val && node.val < node.next.val) || (node.val > prev.val && node.val > node.next.val)) {
                list.add(pos);
                count++;
            }
            pos++;
            prev = node;
            node = node.next;
        }
        if (count < 2) {
            return new int[]{-1, -1};
        }
        list.sort(Comparator.naturalOrder());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            int val = Math.abs(list.get(i) - list.get(i + 1));
            if (val < min) {
                min = val;
            }
        }
        int max = Math.abs(list.get(0) - list.get(list.size() - 1));
        return new int[]{min, max};
    }
}