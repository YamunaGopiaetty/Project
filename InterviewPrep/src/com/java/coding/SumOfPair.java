package com.java.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOfPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,3,4,5,6};
		
		int target = 7;
		
		
		System.out.println("============= using loop ================"); 
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j] == target) {
					System.out.println("Array values: "+arr[i]+ " ,"+arr[j]);
					System.out.println("Array Index: "+i+ " ,"+j);
				}
			}
		}
		
		
		System.out.println("============using streams===============");
		Set<Integer> set = new HashSet<>();

		Arrays.stream(arr).forEach(num -> {
		    int complement = target - num;
		    if (set.contains(complement)) {
		        System.out.println(complement + " , " + num);
		    }
		    set.add(num);
		});
		
	}

}
