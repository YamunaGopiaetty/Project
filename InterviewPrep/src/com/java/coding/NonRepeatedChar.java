package com.java.coding;

public class NonRepeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String s="swiss";
            System.out.println(nonRep(s));
	}
	
	public static Character nonRep(String str) {
		
		for(int i=0;i<str.length()-1;i++) {
			char ch = str.charAt(i);
			 if(str.indexOf(ch) == str.lastIndexOf(ch)) {
				return ch;
			}
		}
		return 0;
	}

}
