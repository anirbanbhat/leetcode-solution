package com.leetcode.easy;

/**
 * 
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with
 * O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Example 1:
 * 
 * Given nums = [3,2,2,3], val = 3,
 * 
 * Your function should return length = 2, with the first two elements of nums being 2.
 * 
 * It doesn't matter what you leave beyond the returned length.
 * 
 * Example 2:
 * 
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * 
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * 
 * Note that the order of those five elements can be arbitrary.
 * 
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * 
 * Confused why the returned value is an integer but your answer is an array?
 * 
 * Note that the input array is passed in by reference, which means modification to the input array will be 
 * known to the caller as well.
 * 
 * Internally you can think of this:
 * 
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);
 * 
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * 
 * @author Anirban Bhattacherji
 *
 */

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RemoveElement().run();
	}

	public int removeElement(int[] nums, int val) {
        int index1 = 0, index2 = 0;
        while(index2<nums.length){
            if(nums[index2] == val){
                index2++;
            } else {
                if(index2>index1){
                    nums[index1] = nums[index2];
                }
                index1++;
                index2++;
            }
        }
        return index1;
    }
	
	
	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int[] expected, int expectedLength, int[] output, int outputLength) {
		int expected_size = expectedLength;
		int output_size = outputLength;
		boolean result = true;
		if (expected_size != output_size) {
			result = false;
		}
		for (int i = 0; i < Math.min(expected_size, output_size); i++) {
			result &= (output[i] == expected[i]);
		}
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printIntegerArray(expected);
			System.out.print(" Your output: ");
			printIntegerArray(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}
	
	 public void run() {
		 int[] arr1 = new int[] {3,2,2,3};
		 int[] arr1ExpectedOut = new int[] {2,2};
		 int expectedLength1 = 2;
		 int remove1 = 3;
		 int outputLength1 = removeElement(arr1, remove1);
		 check(arr1ExpectedOut, expectedLength1, arr1, outputLength1);
		 
		 int[] arr2 = new int[] {0,1,2,2,3,0,4,2};
		 int[] arr2ExpectedOut = new int[] {0,1,3,0,4};
		 int expectedLength2 = 5;
		 int remove2 = 2;
		 int outputLength2 = removeElement(arr2, remove2);
		 check(arr2ExpectedOut, expectedLength2, arr2, outputLength2);
	 }
}
