package com.leelcode.medium;

public class NumberOfMatchingSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for(int i=0; i<words.length; i++){
            int wordLength = words[i].length();
            for(int j=0; j<S.length()-wordLength+1; j++){
                if(S.substring(j, j+wordLength).equals(words[i])){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}
