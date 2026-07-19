package com.java.coding;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MoveZerosToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {0,0,1,3,5,0};
		
		/*Scanner sc= new Scanner(System.in);
		System.out.println("enter the Array");
		int input = sc.nextInt();
	
		
		 int[] arr = new int[input];

        
        System.out.println("Enter array elements:");
        for (int i = 0; i < input; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] result = IntStream.concat(
                Arrays.stream(arr).filter(n -> n != 0), 
                Arrays.stream(arr).filter(n -> n == 0)  
        ).toArray();

        System.out.println(Arrays.toString(result));*/
		
		System.out.println("=========using loops=======");
		int j=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
			int temp =arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			j++;
		}
	}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}

		/*System.out.println("=========using concat=======");
		
		int[] result = IntStream.concat(
                Arrays.stream(arr).filter(n -> n != 0), 
                Arrays.stream(arr).filter(n -> n == 0)  
        ).toArray();

        System.out.println(Arrays.toString(result));
        
        System.out.println("=========using Streams=======");
        
        List<Integer> nonZero = Arrays.stream(arr).boxed().filter(b->b!=0).collect(Collectors.toList());
		long ZeroElements = Arrays.stream(arr).filter(b->b==0).count();
		
		for(int i=0; i<ZeroElements;i++) {
		 nonZero.add(0);
		}
		System.out.println(nonZero);*/ 
		
	}
	
	

}
