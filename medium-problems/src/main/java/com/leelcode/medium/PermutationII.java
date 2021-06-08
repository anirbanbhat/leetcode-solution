package com.leelcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * 
 * Input: nums = [1,1,3]
 * Output: [[1, 1, 3], [1, 3, 1], [3, 1, 1]]
 * 
 * @author Anirban Bhattacherji
 *
 */

public class PermutationII {

	public static void main(String[] args) {
		List<List<Integer>> result = permuteUnique(new int[]{1, 2, 3});
		System.out.println("************RESULT*************");
		System.out.println(result);
		
		result = permuteUnique(new int[]{1, 1, 3});
		System.out.println("************RESULT*************");
		System.out.println(result);
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> numList = Arrays.stream(nums)
                                      .boxed()
                                      .collect(Collectors.toList());
        permuteUnique(result, numList, new ArrayList<Integer>());
        return result;
    }
    
    public static void permuteUnique(List<List<Integer>> result, List<Integer> numList, List<Integer> current) {
        if(numList.isEmpty()){
            result.add(new ArrayList<>(current));
            return;
        }
        int size = numList.size();
        Integer prev = null;
        for(int i = 0; i < size; i++){
            int num = numList.remove(0);
            if(prev != null && num == prev){
                numList.add(num);
                continue;
            }
            current.add(num);
            permuteUnique(result, numList, current);
            current.remove(current.size() - 1);
            prev = num;
            numList.add(num);
        }
    }
}
