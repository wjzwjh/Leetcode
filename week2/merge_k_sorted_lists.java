Merge k Sorted Lists/**
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
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeList(ListNode[] lists, int start, int end) {
        if(start == end){
            return lists[start];
        }
        
        if(start < end){
            int mid = start + (end - start) / 2;
            ListNode left = mergeList(lists, start, mid);
            ListNode right = mergeList(lists, mid + 1, end);
            return mergeTwoList(left, right);
        }
        
        return null;
    }
    
    private ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while(left != null && right != null){
            if(left.val < right.val){
                node.next = left;
                left = left.next;
            }else{
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        
        if(left != null) node.next = left;
        else if(right != null) node.next = right;
        
        return dummy.next;
    }
}
