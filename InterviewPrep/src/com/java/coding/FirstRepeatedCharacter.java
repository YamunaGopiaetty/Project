package com.java.coding;

public class FirstRepeatedCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method 

		String s ="swiss";
		System.out.println(firstRep(s));
		
		System.out.println(s.chars().mapToObj(c->(char)c).filter(ch->s.indexOf(ch) != s.lastIndexOf(ch)).findFirst().get());
	}
   public static Character firstRep(String str) {
		
		for(int i=0;i<str.length()-1;i++) {
			char ch = str.charAt(i);
			 if(str.indexOf(ch) != str.lastIndexOf(ch)) {
				return ch;
			}
		}
		return 0;
	}

}
