package com.leelcode.medium;

import java.util.ArrayList;

public class Permutation1 {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = permutation(new int[]{1, 2, 3, 4});
		System.out.println("************RESULT*************");
		printList(result);
	}
	
	public static ArrayList<ArrayList<Integer>> permutation(int[] nums){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> dummy = new ArrayList<>();
		result.add(dummy);
		for (int i = 0; i < nums.length; i++) {
			ArrayList<ArrayList<Integer>> current = new ArrayList<>();
			for(ArrayList<Integer> arr: result) {
				for (int j = 0; j < arr.size()+1; j++) {
					System.out.println("************CURRENT*************");
					System.out.println("j=" + j);
					System.out.println("nums[i]=" + nums[i]);
					System.out.println("result.size()=" + result.size());
					System.out.println("arr=" + arr.toString());
					arr.add(j, nums[i]);
					ArrayList<Integer> temp = new ArrayList<>(arr);
					System.out.println();
					current.add(temp);	
					printList(current);
					arr.remove(j);
				}
			}
			result = current;
		}
		return result;
	}
	
	public static void printList(ArrayList<ArrayList<Integer>> listOfList) {
		System.out.println("[");
		for(ArrayList<Integer> ar: listOfList) {
			System.out.print("\t[");
			for (int i = 0; i < ar.size(); i++) {
				System.out.print(ar.get(i));
				if(i!=ar.size()-1)
					System.out.print(",\t");
			}
			System.out.println("]");
		}
		System.out.println("]");
	}

}
