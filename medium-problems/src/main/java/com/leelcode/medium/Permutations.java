package com.leelcode.medium;

import java.util.*;

public class Permutations {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
		List<List<Integer>> result = permute(new int[]{1, 2, 3, 4});
		
		System.out.println("************RESULT*************");
		System.out.println(result);
		
        result = permute(new int[]{1, 1, 2});
		
		System.out.println("************RESULT*************");
		System.out.println(result);
	}
	
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();
        for(int num : nums){
            ll.add(num);
        }
        LinkedList<Integer> list = new LinkedList<>();
        updateResult(result, ll, list);
        return result;
    }
    
    public static void updateResult(List<List<Integer>>result, LinkedList<Integer> ll, LinkedList<Integer> list){
        int size = ll.size();
        if(size == 0){
            result.add(new ArrayList<>(list));
            //list.removeLast();
            return;
        }
        for(int i = 0; i < size; i++){
            Integer val = ll.removeFirst();
            list.add(val);
            updateResult(result, ll, list);
            list.removeLast();
            ll.add(val);
        }
    }

}
