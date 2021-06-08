package com.leetcode.hard;

/**
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes 
 * is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * 
 * 1 => 2 => 3 => 4 => 5
 * 2 => 1 => 4 => 3 => 5
 * 
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [2,1,4,3,5]
 * 
 * 1 => 2 => 3 => 4 => 5
 * 3 => 2 => 1 => 4 => 5
 * 
 * 
 * 
 * @author Anirban Bhattacherji
 *
 */

public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		ReverseNodesInKGroup reverse = new ReverseNodesInKGroup();
		ListNode head = getNodes(5);
		printNodes(head);
		head = reverse.reverseKGroup(head, 2);
		printNodes(head);
		head = getNodes(7);
		printNodes(head);
		head = reverse.reverseKGroup(head, 3);
		printNodes(head);
	}
	
	
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = new ListNode(0, head);
        ListNode dummy = start;
        ListNode node = head;
        while(node != null){
            for(int i = 0; i < k; i++){
                if(node == null){
                    return dummy.next;
                }
                node = node.next;
            }
            ListNode end = node;
            ListNode currentStart = start.next;
            ListNode last = reverse(currentStart, end);
            start.next = last;
            currentStart.next = end;
            start = currentStart;
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode start, ListNode end){
        ListNode previous = start;
        ListNode current = start.next;
        while(current != end){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    public static void printNodes(ListNode start) {
    	String prefix = "";
    	while(start != null) {
    		System.out.print(prefix + start.val);
    		start = start.next;
    		prefix = " => ";
    	}
    	System.out.println();
    }
    
    public static ListNode getNodes(int num) {
    	ListNode start = new ListNode(num--);
    	while(num > 0) {
    		start = new ListNode(num--, start);
    	}
		return start;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
