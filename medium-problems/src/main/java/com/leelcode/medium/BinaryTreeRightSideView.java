package com.leelcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Anirban
 *
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 *
 */

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		Node root = loadTree();
		List<Integer> result = rightSideView(root);
		System.out.println(result.toString());
	}
	
	public static List<Integer> rightSideView(Node root) {
		List<Integer> returnList = new ArrayList<>();
		if(root == null) {
			return returnList;
		}
		ArrayList<Node> current = new ArrayList<>();
		ArrayList<Node> next = new ArrayList<>();
		current.add(root);
		returnList.add(root.val);
		while(!current.isEmpty()) {
			Node currentNode = current.remove(0);
			if(currentNode.right!=null) {
				next.add(currentNode.right);
			}
			if(currentNode.left!=null) {
				next.add(currentNode.left);
			}
			if(current.isEmpty()) {
				if(!next.isEmpty()) {
					returnList.add(next.get(0).val);
				}
				ArrayList<Node> temp = current;
				current = next;
				next = temp;
			}
		}
		return returnList;
	}

	public static Node loadTree() {
		/*
		 *                  55
		 *           24                 68
		 *    12        35          61        
		 *  5   20    30   50     57   64    
		 *    15          37
		 *       17   
		 * O/P 55, 68, 61, 64, 37, 17 
		 */
		Node node = new Node(55);
		node.left = new Node(24);
		node.left.left = new Node(12);
		node.left.left.left = new Node(5);
		node.right = new Node(68);
		node.left.left.right = new Node(20);
		node.left.left.right.left = new Node(15);
		node.left.left.right.left.right = new Node(17);
		node.left.right = new Node(35);
		node.left.right.left = new Node(30);
		node.left.right.right = new Node(50);
		node.left.right.right.left = new Node(37);
		node.right.left = new Node(61);
		node.right.left.right = new Node(64);
		node.right.left.left = new Node(57);
		return node;
	}
	
	static class Node {
		Node left;
		Node right;
		int val;
		public Node(int v) {
			val = v;
			left = null;
			right = null;
		}
	}
}
