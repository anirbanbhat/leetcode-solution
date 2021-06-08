package com.leetcode.linkedlist;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	
	public static void printList(ListNode head) {
		String prefix = "";
		while(head != null) {
			System.out.print(prefix + head.val);
			prefix = " -> ";
			head = head.next;
		}
		System.out.println();
	}
}
