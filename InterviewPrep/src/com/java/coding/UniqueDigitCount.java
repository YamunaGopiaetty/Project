package com.java.coding;



import java.util.Scanner;


public class UniqueDigitCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String n="11223344556";
		
		
		System.out.println("================using String==========");
		long unique = String.valueOf(n).chars().map(i->i-'0').distinct().count();
		System.out.println("using String:" + unique);
		
		 Scanner sc = new Scanner(System.in);
		 System.out.println("================using Streams ==========");
	        System.out.print("Enter a number: ");
	        int num = sc.nextInt();
	        
	        
	        /*List<Integer> list = new ArrayList<>();
	        while(num>0) {
	        	int digit=num%10;
	        	
	        	if(!list.contains(digit)) {
	        		list.add(digit);
	        	}
	        	num = num / 10;
	        }
	        
	        System.out.println("Unique digits: " + list);

	        /*long uniqueCount = String.valueOf(Math.abs(num))
	                .chars()
	                .distinct()
	                .count();

	        System.out.println("Unique digit count: " + uniqueCount);*/
	        
	        
	      System.out.println ("Unique digit count: " +String.valueOf(num).chars().map(c-> c -'0').distinct().count());
	       // System.out.println ("Unique digit count: " + String.valueOf(num).chars().mapToObj(c-> c -'0').collect(Collectors.toSet()).size());
	        
	        
	        
			
		}

	

}
