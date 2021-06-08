package com.leelcode.medium;

/**
 * 
 * @author Anirban Bhattacherji
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 * The replacement must be in place and use only constant extra memory.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * 
 * Example 2:
 * 
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * 
 * Example 3:
 * 
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * 
 * Example 4:
 * 
 * Input: nums = [1]
 * Output: [1]
 *  
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 */

public class NextPermutation {

	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3};
		print(nums);
		nextPermutation(nums);
		print(nums);
		nums = new int[] {1,3,2};
		print(nums);
		nextPermutation(nums);
		print(nums);
		nums = new int[] {2,3,1};
		print(nums);
		nextPermutation(nums);
		print(nums);
		nums = new int[] {100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		print(nums);
		nextPermutation(nums);
		print(nums);
	}
	
	/**
	 * 
	 * Single Pass Approach
	 * Algorithm
	 * 
	 * First, we observe that for any given sequence that is in descending order, no next larger permutation is possible. For example, no next permutation is possible for the following array:
	 * 
	 * [9, 5, 4, 3, 1]
	 * We need to find the first pair of two successive numbers a[i]a[i] and a[i-1]a[i−1], from the right, which satisfy a[i] > a[i-1]a[i]>a[i−1]. Now, no rearrangements to the right of a[i-1]a[i−1] can create a larger permutation since that subarray consists of numbers in descending order. Thus, we need to rearrange the numbers to the right of a[i-1]a[i−1] including itself.
	 * 
	 * Now, what kind of rearrangement will produce the next larger number? We want to create the permutation just larger than the current one. Therefore, we need to replace the number a[i-1]a[i−1] with the number which is just larger than itself among the numbers lying to its right section, say a[j]a[j].
	 * 
	 *  Next Permutation 
	 * 
	 * We swap the numbers a[i-1]a[i−1] and a[j]a[j]. We now have the correct number at index i-1i−1. But still the current permutation isn't the permutation that we are looking for. We need the smallest permutation that can be formed by using the numbers only to the right of a[i-1]a[i−1]. Therefore, we need to place those numbers in ascending order to get their smallest permutation.
	 * 
	 * But, recall that while scanning the numbers from the right, we simply kept decrementing the index until we found the pair a[i]a[i] and a[i-1]a[i−1] where, a[i] > a[i-1]a[i]>a[i−1]. Thus, all numbers to the right of a[i-1]a[i−1] were already sorted in descending order. Furthermore, swapping a[i-1]a[i−1] and a[j]a[j] didn't change that order. Therefore, we simply need to reverse the numbers following a[i-1]a[i−1] to get the next smallest lexicographic permutation.
	 * 
	 * The following animation will make things clearer:
	 * 
	 * @param nums
	 */

	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
	
	private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    public static void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
    
    private static void print(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			System.out.print("---");
		}
		System.out.println();
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < len; i++) {
			System.out.print("---");
		}
		System.out.println();
	}
    
}
