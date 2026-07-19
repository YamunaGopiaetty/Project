package com.java.coding;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Anangram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="silent";
		String str2="listen";
		
		
		Map<Object, Long> st1 = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(v->v,Collectors.counting()));
		Map<Object, Long> st2 = str2.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(v->v,Collectors.counting()));
		
		if(st1.equals(st2)) {
			System.out.println("both strings are anangram");
		}else {
			System.out.println("both strings are not anangram");
		
		}
		
		System.out.println("=============using loop======");
		char[] arr1 = str.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		if(Arrays.equals(arr1, arr2)) {
			System.out.println("both strings are anangram");
		}else {
			System.out.println("both strings are not anangram");
		}

	}

}
