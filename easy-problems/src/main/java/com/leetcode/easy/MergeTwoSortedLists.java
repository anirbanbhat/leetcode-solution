package com.leetcode.easy;


/**
 * 
 * @author Anirban
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by 
 * splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 */

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(4);
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(4);
		printListNode(head1);
		printListNode(head2);
		printListNode(mergeTwoLists(head1, head2));
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode dummy2 = dummy;
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                dummy2.next = l2;
                l2 = l2.next;
            } else {
                dummy2.next = l1;
                l1 = l1.next;
            }
            dummy2 = dummy2.next;
        }
        while(l1 != null){
            dummy2.next = l1;
            l1 = l1.next;
            dummy2 = dummy2.next;
        }
        while(l2 != null){
            dummy2.next = l2;
            l2 = l2.next;
            dummy2 = dummy2.next;
        }
        return dummy.next;
    }
	
	public static void printListNode(ListNode head) {
		String prefix = "";
		while(head != null) {
			System.out.print(prefix + head.val);
			prefix = " -> ";
			head = head.next;
		}
		System.out.println();
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
