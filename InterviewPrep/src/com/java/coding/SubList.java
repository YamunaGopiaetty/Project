package com.java.coding;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 List<Integer> arr = Arrays.asList(1,2,3,4,5,6,7,8);
		int range =2;
		System.out.println("============using loops==========");
		for(int i=0;i<=arr.size()-range;i+=range) {
		List<Integer> list = arr.subList(i, i+range);
		System.out.println(list);
		}
		
		System.out.println("============using streams=======");
		IntStream.range(0, arr.size() / range)
        .mapToObj(i ->
        arr.subList(i * range, i * range + range))
        .forEach(System.out::println);
		
		
		System.out.println("==========using Grouping==========="); 
		Map<Integer, List<Integer>> grouped = IntStream.range(0,arr.size()).boxed().collect(Collectors.groupingBy(i->i/range,
				Collectors.mapping(arr::get, Collectors.toList())));
		grouped.values().forEach(System.out::println);
	}

}
