package com.java.coding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondLeargestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="my name is yamuna";
		System.out.println( Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(String::length)).entrySet()
		.stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).skip(1).findFirst().get());
		
		
       System.out.println("======================using loop=========");
		String[] arr = {"apple", "banana", "orange", "mango"};
		
		String largest ="";
		String secondLergest="";
		
		for(String s: arr) {
			if(s.compareTo(largest)>0) {
				secondLergest=largest;
				largest=s;
			}
			
			else if(s.compareTo(secondLergest)>0 && !s.equals(largest)) {
				secondLergest=s;
			}

		}
		
		System.out.println("Second Largest String: " + secondLergest);
		
	}

}
