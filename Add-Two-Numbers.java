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
        
        ListNode current = new ListNode(0);
        ListNode output = current;
        int carry = 0;
        
        do {    //do-while is used to make it easier to sum the last pair of digits
            current.val = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + carry;   //ternary operator used for edge case
            if(current.val > 9) {                                                               //where only 1 digit is null or carry=1
                carry = 1;
                current.val -= 10;
            } else {
                carry = 0;
            }
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            if((l1 == null) && (l2 == null)) {
                break;
            }
            
            current.next = new ListNode(0);
            current = current.next;
        } while(l1 != null || l2 != null);
        if(carry > 0) {
            current.next = new ListNode(1);
        }
        
        return output;
    }
}