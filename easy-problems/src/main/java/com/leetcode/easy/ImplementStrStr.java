package com.leetcode.easy;

public class ImplementStrStr {

	public static void main(String[] args) {
		System.out.println(2==strStr("hello", "ll"));
		System.out.println(-1==strStr("aaaaa", "bba"));
		System.out.println(0==strStr("aaaaa", ""));
	}

	public static int strStr(String haystack, String needle) {
        int indexHaystack = 0;
        int indexNeedle = 0;
        int returnIndex = -1;
        if(needle == null || haystack == null){
            return returnIndex;
        }
        if(needle.length() == 0){
            return 0;
        }
        for(int i=0; i<=haystack.length() - needle.length(); i++){
            indexHaystack = i;
            while(haystack.charAt(indexHaystack) == needle.charAt(indexNeedle)){
                indexHaystack++;
                indexNeedle++;
                if(indexHaystack>=haystack.length() || indexNeedle>=needle.length()){
                    break;
                }
            }
            if(indexNeedle==needle.length()){
                returnIndex = i;
                break;
            }
            indexNeedle = 0;
        }
        return returnIndex;
    }
}
