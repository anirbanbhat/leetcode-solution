package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 
 * @author anirban
 * 
 * See findMedianSortedArrays5
 *
 */

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
		System.out.println(findMedianSortedArrays2(new int[]{1,2}, new int[]{3,4}));
		//System.out.println(findMedianSortedArrays3(new int[]{1,2}, new int[]{3,4}));
		//System.out.println(findMedianSortedArrays3(new int[]{1,3}, new int[]{2}));
		//System.out.println(findMedianSortedArrays3(new int[]{1}, new int[]{1}));
		//System.out.println(findMedianSortedArrays3(new int[]{}, new int[]{1}));
		System.out.println(findMedianSortedArrays4(new int[]{1,2}, new int[]{3,4}));
		System.out.println(findMedianSortedArrays4(new int[]{1,1,1,1,1,1,1,1,1,1,4,4}, new int[]{1,3,4,4,4,4,4,4,4,4,4}));
		
		System.out.println(findMedianSortedArrays5(new int[]{1,2}, new int[]{3,4}));
		System.out.println(findMedianSortedArrays5(new int[]{1,1,1,1,1,1,1,1,1,1,4,4}, new int[]{1,3,4,4,4,4,4,4,4,4,4}));
		System.out.println(findMedianSortedArrays5(new int[]{1}, new int[]{}));
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i1 = 0; int i2 = 0; int count = 0; 
        int halfLength = (nums1.length + nums2.length)/2 + 1;
        int[] arr = new int[2];
        while(i1 < nums1.length && i2 < nums2.length && count < halfLength){
            if(nums1[i1] < nums2[i2]){
                arr[0] = arr[1];
                arr[1] = nums1[i1++];
                count++;
            } else {
                arr[0] = arr[1];
                arr[1] = nums2[i2++];
                count++;
            }
        }
        while(i1 < nums1.length && count < halfLength){
            arr[0] = arr[1];
            arr[1] = nums1[i1++];
            count++;
        }
        while(i2 < nums2.length && count < halfLength){
            arr[0] = arr[1];
            arr[1] = nums2[i2++];
            count++;
        }
        if((nums1.length + nums2.length)%2 == 0){
            return ((double)arr[1] + (double)arr[0])/2;
        }
        return (double)arr[1];
    }

	public static double findMedianSortedArraysOld(int[] nums1, int[] nums2) {
        Queue<Integer> q = new PriorityQueue<Integer>();
        for(int i: nums1) {
        	q.add(i);
        }
        for(int i: nums2) {
        	q.add(i);
        }
        int size = q.size();
        int halfSize = (q.size()%2==1)?q.size()/2:q.size()/2-1;
        for(int i=0; i<halfSize; i++) {
        	q.poll();
        }
        return (size%2==1)?q.poll():((double)q.poll() + (double)q.poll())/2;
    }
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        List<Integer> l = new ArrayList<Integer>();
        for(int i: nums1) {
        	l.add(i);
        }
        for(int i: nums2) {
        	l.add(i);
        }
        Collections.sort(l);
        return (l.size()%2==1)?l.get(l.size()/2):((double)l.get(l.size()/2-1) + (double)l.get(l.size()/2))/2;
    }
	
	/*public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        int num1Count = 0;
        int num2Count = 0;
        if(nums1.length==0) {
        	set.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        } else if(nums2.length==0) {
        	set.addAll(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        } else {
        	while(num1Count<nums1.length || num2Count<nums2.length) {
        		if(num1Count>=nums1.length && num2Count<nums2.length) {
                    set.add(nums2[num2Count++]);
        		} else if(num2Count>=nums2.length && num1Count<nums1.length) {
        			set.add(nums1[num1Count++]);
        		} else if (nums2[num2Count]<nums1[num1Count]) {
        			set.add(nums2[num2Count++]);
        		} else if(nums1[num1Count]<nums2[num2Count]) {
        			set.add(nums1[num1Count++]);
        		} else if(nums1[num1Count]==nums2[num2Count]) {
        			set.add(nums1[num1Count++]);
                    num2Count++;
        		}
        	}
        }
        //set.
        double median = set.size()%2==0?((double)set.get(set.size()/2) + (double)set.get(set.size()/2-1))/2:(double)set.get(set.size()/2);
        return median;
    }*/
	
	public static double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        int k = (nums1.length + nums2.length + 2)/2;
        PriorityQueue<Integer> top = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        for(int i:nums1){
        	if(count == k) {
        		if(top.peek()>i) {
        			top.poll();
            		top.offer(i);
        		}
        	} else {
        		top.offer(i);
        		count++;
        	}
        }
        for(int i:nums2){
        	if(count == k) {
        		if( top.peek()>i) {
        			top.poll();
            		top.offer(i);
        		}
        	} else {
        		top.offer(i);
        		count++;
        	}
        }
        if((nums1.length + nums2.length)%2==1) {
        	return (double)top.peek();
        } else {
        	return (top.poll() + top.poll())/2.0;
        }
    }
	
	public static double findMedianSortedArrays5(int[] nums1, int[] nums2) {
		int length = nums1.length + nums2.length;
		if(length == 0) {
			return 0;
		}
		boolean isEven = length%2==0;
		int[] arr = new int[length/2+1];
		int nums1Index = 0;
		int nums2Index = 0;
		int index = 0;
		while (index<arr.length && nums1Index<nums1.length && nums2Index<nums2.length) {
			if(nums1[nums1Index]<nums2[nums2Index]) {
				arr[index++] = nums1[nums1Index++];
			} else {
				arr[index++] = nums2[nums2Index++];
			}
		}
		while(index<arr.length && nums1Index<nums1.length) {
			arr[index++] = nums1[nums1Index++];
		}
		while(index<arr.length && nums2Index<nums2.length) {
			arr[index++] = nums2[nums2Index++];
		}
		return isEven?(arr[arr.length-1] + arr[arr.length-2])/2.0:arr[arr.length-1];
	}
}
