package com.java.coding;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str ="raja rajesh raja rajesh raja kumar";
		
		System.out.println("==============Dencending order===================");
		Arrays.stream(str.split(" "))
	      .collect(Collectors.groupingBy(v -> v, Collectors.counting()))
	      .entrySet().stream()
	      .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
	      .forEach(e->System.out.println(e.getKey() + " - "+e.getValue()));
		
		System.out.println("================Ascending order =================");
		Arrays.stream(str.split(" "))
	      .collect(Collectors.groupingBy(v -> v, Collectors.counting()))
	      .entrySet().stream()
	      .sorted(Map.Entry.<String,Long>comparingByValue())
	      .forEach(e->System.out.println(e.getKey() + " - "+e.getValue()));
		
	}

}
