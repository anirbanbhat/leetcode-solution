package com.leetcode.treesandgraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * Input: [1,0,2,3,9]
 *    1
 *   / \
 *  0   2
 *     / \
 *    3   9
 * 
 * Output: [0,1,3,2,9]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author Anirban Bhattacherji
 *
 */

public class BinaryTreeInorderTraversal {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(9);
		System.out.println(new BinaryTreeInorderTraversal().inorderTraversalRecursive(root));
		System.out.println(new BinaryTreeInorderTraversal().inorderTraversalIterative(root));
		
	}

	public List<Integer> inorderTraversalRecursive(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		inorderTraversalRecursive(root, list);
		return list;
	}

	public void inorderTraversalRecursive(TreeNode node, List<Integer> list) {
		if (node.left != null) {
			inorderTraversalRecursive(node.left, list);
		}
		list.add(node.val);
		if (node.right != null) {
			inorderTraversalRecursive(node.right, list);
		}
	}
	
	public List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		while(!stack.isEmpty() || current != null) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			} else {
				TreeNode temp = stack.pop();
				list.add(temp.val);
				current = temp.right;
			}
		}
		return list;
	}
}
