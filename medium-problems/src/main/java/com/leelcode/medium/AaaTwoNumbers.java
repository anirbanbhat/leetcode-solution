package com.leelcode.medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in 
 * reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a 
 * linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 * @author Anirban Bhattacherji
 *
 */
public class AaaTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    
    public static void main(String[] args) {
		ListNode head1 = add(new int[] {2, 4, 3});
		print(head1);
		ListNode head2 = add(new int[] {5, 6, 4});
		print(head2);
		AaaTwoNumbers atn = new AaaTwoNumbers();
		ListNode result = atn.addTwoNumbers(head1, head2);
		print(result);
	}
	
	public static ListNode add(int[] intList) {
		ListNode head = new ListNode(intList[0]);
        ListNode lnx = head;
        lnx.next = null;
        for(int i = 1; i <= intList.length - 1; i++){
            ListNode ln = new ListNode(intList[i]);
            ln.next = null;
            lnx.next = ln;
            lnx = ln;
        }
        return head;
	}
	
	public static void print(ListNode n) {
		System.out.print(n.val);
		while(n.next != null){
			System.out.print(" -> ");
            n = n.next;
            System.out.print(n.val);
        }
		System.out.println();
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

}
