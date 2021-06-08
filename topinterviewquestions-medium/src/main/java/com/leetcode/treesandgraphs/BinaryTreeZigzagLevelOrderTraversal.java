package com.leetcode.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to 
 * right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 
 * @author Anirban Bhattacherji
 *
 */

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(zigzagLevelOrder(root));
		
		root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(zigzagLevelOrder(root));
		
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(zigzagLevelOrder(root));
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        boolean rightToLeft = true;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> currentList = new ArrayList<>();
            LinkedList<TreeNode> temp = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode current = q.remove(0);
                currentList.add(current.val);
                if(rightToLeft){
                    if(current.left != null){
                    	temp.addFirst(current.left);
                    }
                    if(current.right != null){
                    	temp.addFirst(current.right);
                    }
                } else {
                    if(current.right != null){
                    	temp.addFirst(current.right);
                    }
                    if(current.left != null){
                    	temp.addFirst(current.left);
                    }
                }
            }
            q.addAll(temp);
            rightToLeft = !rightToLeft;
            list.add(currentList);
        }
        return list;
    }
}
