package com.leelcode.medium;

/**
 * 
 * @author Anirban
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 * Example:
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 */

public class SwapNodesInPairs {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		printListNode(head);
		printListNode(swapPairs(head));
	}
	
	public static ListNode swapPairs(ListNode head) {
		if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode back = dummy;
        ListNode front = head.next;
        while(back.next != null && back.next.next != null){
            back.next.next = front.next;
            front.next = back.next;
            back.next = front;
            back = back.next.next;
            if(back.next == null) {
            	break;
            }
            front = back.next.next;
            printListNode(dummy.next);
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
