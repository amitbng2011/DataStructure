package com.technical.test.ed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/removing-string-that-is-an-anagram-of-an-earlier-string/
 *
 */
public class RemoveDuplicateAnagrams {

	public static void main(String[] args) {

//		aa bb cc aa
		
		List<String> list = Arrays.asList("geeks", "keegs", "code", "doce");
		RemoveDuplicateAnagrams obj = new RemoveDuplicateAnagrams();
		List<String>  ans = obj.funWithAnagrams(list);
		ans.stream().forEach(s->{
			System.out.print(s+" ");
		});
	}

	public List<String> funWithAnagrams(List<String> text) {
		// Write your code here

		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();

		for(int i=0; i<text.size(); i++){
			char[] curr = text.get(i).toCharArray();
			Arrays.sort(curr);
			String word = new String(curr);
			if(!set.contains(word)){
				list.add(text.get(i));
				set.add(word);
			}
		}
		
		Collections.sort(list);
		return list; 
	}
}
