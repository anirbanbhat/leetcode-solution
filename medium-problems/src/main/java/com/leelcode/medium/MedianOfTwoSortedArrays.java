package com.leelcode.medium;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		double val = findMedianSortedArrays(new int[] {1, 3}, new int[] {2});
        System.out.println("Response: " + val + "\n*************\n");
        val = findMedianSortedArrays(new int[] {}, new int[] {2, 3});
        System.out.println("Response: " + val + "\n*************\n");
        val = findMedianSortedArrays(new int[] {1,2}, new int[] {3, 4});
        System.out.println("Response: " + val + "\n*************\n");
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		printArray(nums1);
		printArray(nums2);
		int totalCount = nums1.length + nums2.length;
		System.out.println("totalCount: " + totalCount);
        int len = (nums1.length + nums2.length)/2+1;
        int counter1 = 0;
        int counter2 = 0;
        int counter = 0;
        int[] newArray = new int [len];
        while(counter<len && counter1<nums1.length && counter2<nums2.length){
            if(nums1[counter1]<nums2[counter2]){
                newArray[counter++]=nums1[counter1++];
            }else{
                newArray[counter++]=nums2[counter2++];
            }
        }
        if(counter1>=nums1.length){
            while(counter<len){
                newArray[counter++]=nums2[counter2++];
            }
        }
        if(counter2>=nums2.length){
            while(counter<len){
                newArray[counter++]=nums1[counter1++];
            }
        }
        printArray(newArray);
        if(len==1)
            return newArray[len-1];
        double returnVal = (totalCount%2!=0)?newArray[len-2]:(double)(newArray[len-1]+newArray[len-2])/2;
        return returnVal;
    }
	
	public static void printArray(int[] nums) {
		System.out.println("LENGTH - " + nums.length);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

}
