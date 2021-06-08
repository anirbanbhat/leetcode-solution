package com.leelcode.medium;

/**
 * 
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * A valid BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * @author Anirban Bhattacherji
 *
 */

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		System.out.println(isValidBST(root));
		root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		System.out.println(isValidBST(root));
		root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(isValidBST(root));
		root = new TreeNode(Integer.MIN_VALUE);
		root.right = new TreeNode(Integer.MAX_VALUE);
		System.out.println(isValidBST(root));
	}
	
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
	
	public static boolean isValidBST(TreeNode node, long left, long right) {
        boolean isValid = true;
        if(node.left != null) {
            isValid = node.val > node.left.val && node.left.val > left && isValidBST(node.left, left, node.val);
        }
        if(isValid && node.right != null){
            isValid = node.val < node.right.val && node.right.val < right && isValidBST(node.right, node.val, right);
        }
        return isValid;
    }
	
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
