package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class CheckPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
	}
	public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        List<Integer> l = getIntArray(x);
        boolean flag = true;
        for(int i=0; i<l.size()/2; i++){
            if(l.get(i)!=l.get(l.size()-i-1)){
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    public static List<Integer> getIntArray(int x){
        List<Integer> l = new ArrayList<>();
        while(x>0){
            l.add(x%10);
            x /= 10;
        }
        return l;
    }

}
