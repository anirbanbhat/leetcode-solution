package com.leetcode.linkedlist;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we 
 * are talking about the node number and not the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time 
 * complexity.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * 
 * Example 2:
 * 
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *  
 * 
 * Constraints:
 * 
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * The length of the linked list is between [0, 10^4].
 *  
 * @author Anirban Bhattacherji
 *
 */

public class OddEvenLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ListNode.printList(head); // 1 -> 2 -> 3 -> 4 -> 5 -> 6
		oddEvenList(head);
		ListNode.printList(head); // 1 -> 3 -> 5 -> 2 -> 4 -> 6
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		ListNode.printList(head); // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
		oddEvenList(head);
		ListNode.printList(head); // 1 -> 3 -> 5 -> 7 -> 2 -> 4 -> 6
	}

	public static ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            ListNode tempSlow = slow.next;
            ListNode tempFast = fast.next.next;
            slow.next = fast.next;
            slow.next.next = tempSlow;
            fast.next = tempFast;
            slow = slow.next;
            fast = fast.next;
        }
        return head;
    }
	
	public static ListNode oddEvenList2(ListNode head) {
		if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        while(even != null && even.next != null){
            ListNode temp1 = odd.next;
            odd.next = even.next;
            ListNode temp2 = even.next.next;
            odd = odd.next;
            odd.next = temp1;
            even.next = temp2;
            even = temp2;
            
        }
        return head;
    }
}
