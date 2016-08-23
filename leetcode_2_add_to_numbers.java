/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tail = null;
        int c=0;
        while(l1!=null || l2!=null) {
            int n1 = 0, n2=0, sum=0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }
            
            sum = (n1 + n2+c)%10;
            c = (n1+n2+c)/10;
            if (result == null) {
                result = new ListNode(sum);
                tail = result;
            } else {
                ListNode newNode = new ListNode(sum);
                tail.next = newNode;
                tail = newNode;
            }
        }
        if (c!=0) {
            ListNode newNode = new ListNode(c);
            tail.next = newNode;
            tail = newNode;
        }
        return result;
    }
}