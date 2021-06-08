package com.leetcode.sortingandsearching;

public class SearchForARange {

	public static void main(String[] args) {
		int[] result = new int[2];
		result = searchRange(new int[] {1, 4}, 4);
		System.out.println("[" + result[0] + ", " + result[0] + "]");
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] range = new int[] { -1, -1 };
		if (nums.length < 1) {
			return range;
		}
		if (nums.length == 1 && nums[0] == target) {
			return new int[] { 0, 0 };
		}
		boolean found = false;
		int start = 0, end = nums.length - 1, mid = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				found = true;
				break;
			}
			if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if (!found) {
			return range;
		}
		start = mid;
		while (start - 1 >= 0 && nums[start - 1] == target) {
			start--;
		}
		range[0] = start;
		end = mid;
		while (end + 1 < nums.length && nums[end + 1] == target) {
			end++;
		}
		range[1] = end;
		return range;
	}
}
