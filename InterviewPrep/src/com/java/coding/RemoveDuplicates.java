package com.java.coding;



import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String str = sc.nextLine();
		
		String result = "";
		
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			
			if(ch == ' ' ) {
				result +=ch;
			}
			
			else if(result.indexOf(ch) == -1) {
				result +=ch;
			}
		}
		System.out.println(result);
	

	
	
		System.out.println("=======LinkedHashSet=======");
		
	
		Set<Character> seen = new LinkedHashSet<>();
		StringBuilder result1 = new StringBuilder();

		for (char ch : str.toCharArray()) {

		    if (ch == ' ') {
		        result1.append(ch);      
		    } else if (seen.add(ch)) {
		        result1.append(ch);        
		    }
		}

		System.out.println(result1.toString());
		

		System.out.println("=======using streams=======");
		Set<Character> seen1 = new LinkedHashSet<>();
		String res = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> ch == ' ' || seen1.add(ch))
                .map(String::valueOf)
                .collect(Collectors.joining());
		
		System.out.println(res);

		System.out.println("==============");
		Character duplicates = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> str.indexOf(ch) != str.lastIndexOf(ch)).findFirst().get(); // occurs more than once
               // .collect(Collectors.toSet());

        System.out.println("Duplicate characters: " + duplicates);
			
	}
	
	
	
	
	
}
