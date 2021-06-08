package com.leelcode.medium;

import java.util.Arrays;

public class ZigzagConversion {

	public static void main(String[] args) {
		String ret = convert3("PAYPALISHIRING", 3);
        System.out.println(ret);
        ret = convert("PAYPALISHIRING", 4);
        System.out.println(ret);
        ret = convert("AB", 1);
        System.out.println(ret);
	}
	
	public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int gap = (numRows - 1) << 1;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            int current = i;
            int offset = gap - (i<<1);
            while(current<s.length()){
                if(offset != 0){
                    // avoid inserting duplicate elements
                    // in the first and last row
                    result.append(s.charAt(current));
                    current += offset;
                }
                offset = gap - offset;
            }
        }
        return result.toString();
    }
    
    public static String convert3(String s, int numRows) {
    	if(numRows == 1) return s;
    	StringBuilder sb = new StringBuilder();
        int gapBellow = ((numRows - 1) * 2);
        int gapUp = 0;
        for(int counter = 0; counter < numRows; counter++){
            int index = counter;
            if(index < s.length()){
                sb.append(s.charAt(index));
            }
            while(index < s.length()){
                if(gapBellow > 0){
                    index += gapBellow;
                    if(index < s.length()){
                        sb.append(s.charAt(index));
                    }
                }                
                if(gapUp > 0){
                    index += gapUp;
                    if(index < s.length()){
                        sb.append(s.charAt(index));
                    }
                }
            }
            gapBellow -= 2;
            gapUp += 2;
        }
        return sb.toString();
    }
}
