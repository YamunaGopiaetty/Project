package com.java.coding;

import java.util.Arrays;

public class SortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {1,7,8,9,5,3};
		Arrays.stream(arr).sorted().forEach(System.out::print);
		
		
		System.out.println("===========using ForLoop==========");
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]= temp;
				}
			}
			
			
		}
		
		for(int num : arr) {
			System.out.print(num+"");
		}
	}

}
