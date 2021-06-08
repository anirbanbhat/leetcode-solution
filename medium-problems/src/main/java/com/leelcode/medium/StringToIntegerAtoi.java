package com.leelcode.medium;

public class StringToIntegerAtoi {

	public static void main(String[] args) {
		int val = myAtoi("42");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
		val = myAtoi("   -42");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
		val = myAtoi("4193 with words");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
		val = myAtoi("words and 987");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
		val = myAtoi("-91283472332");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
        val = myAtoi("-1");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
        val = myAtoi("-2147483649");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
        
        
        val = myAtoi2("42");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
		val = myAtoi2("   -42");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
		val = myAtoi2("4193 with words");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
		val = myAtoi2("words and 987");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
		val = myAtoi2("-91283472332");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
        val = myAtoi2("-1");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
        val = myAtoi2("-2147483649");
		System.out.print("Result: ");
        System.out.println(val);
        System.out.println("***************************************");
	}
	
	public static int myAtoi(String str) {
		System.out.println("Input: " + str);
        int i=0;
        str = str.trim();
        if (str == null || str.length() < 1)
		    return 0;
        int result = 0;
        boolean isPositive = true;
        if(str.charAt(0)=='-') {
        	isPositive = false;
        	i++;
        }
        if(str.charAt(0)=='+')
        	i++;
        	
        while(i<str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
    		int pop = str.charAt(i) - '0';
            if(i>1 && !isPositive && result>0)
            	result = (0-result);
            if(result>Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && pop > 7))
                return Integer.MAX_VALUE;
            if(result<Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && pop > 8))
                return Integer.MIN_VALUE;
            //System.out.println("r: " + result + ", p: " + pop);
            result = (result>=0)?(result*10 + pop):(result*10 - pop);
        	i++;
        }
        if(!isPositive && result>0)
        	result = (0-result);
        return result;
    }
	
	public static int myAtoi2(String str) {
        if(str == null || str.trim().equals("")){
            return 0;
        }
        str = str.trim();
        int index = 0;
        boolean isPositive = true;
        if(str.charAt(index) == '-'){
            isPositive = false;
            index++;
        } else if(str.charAt(index) == '+'){
            index++;
        }
        StringBuilder num = new StringBuilder("");
        while(index<str.length()){
            if(str.charAt(index)>='0' && str.charAt(index)<='9'){
                num.append(Character.toString(str.charAt(index++)));
            } else {
                break;
            }
        }
        String st = num.toString();
        if(!st.equals("")){
            long l = isPositive?Long.parseLong(st):0-Long.parseLong(st);
            if(l>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            } else if(l<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            } else {
                return (int) l;
            }
        }
        return 0;
    }

}
