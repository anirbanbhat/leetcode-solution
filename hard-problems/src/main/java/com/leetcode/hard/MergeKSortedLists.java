package com.leetcode.hard;

/**
 * 
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */


import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		ListNode[] lns = new ListNode[3];
		ListNode ln1 = new ListNode(1);
	    ln1.next = new ListNode(4);
	    ln1.next.next = new ListNode(5);
	    printListNode(ln1);
		ListNode ln2 = new ListNode(1);
		ln2.next = new ListNode(3);
		ln2.next.next = new ListNode(4);
		printListNode(ln2);
		ListNode ln3 = new ListNode(2);
		ln3.next = new ListNode(6);
		ln3.next.next = new ListNode(9);
		printListNode(ln3);
		lns[0] = ln1;
		lns[1] = ln2;
		lns[2] = ln3;
		ListNode result = mergeKLists(lns);
		printListNode(result);
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((l1, l2) -> {
        	return l1.val - l2.val;
        });
        for(ListNode node: lists){
        	System.out.println("**************");
        	printListNode(node);
        	
            if(node!=null){
            	System.out.println(node.val);
                pq.offer(node);
                printListNode(pq.peek());
            	System.out.println("##############");
            }
        }
        printListNode(pq.peek());
        ListNode n = new ListNode(0);
        ListNode head = n;
        while(!pq.isEmpty()){
            ListNode current = pq.poll();
            n.next = current;
            n = n.next;
            if(current.next!=null)
                pq.offer(current.next);
        }
        printListNode(head);
        return head.next;
    }
	
	public static void printListNode(ListNode ln) {
		while(ln!=null) {
			System.out.print(ln.val);
			if(ln.next!=null) {
				System.out.print("->");
			}
			ln = ln.next;
		}
		System.out.println();
	}

}