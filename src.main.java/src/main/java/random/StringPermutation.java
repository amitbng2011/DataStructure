package src.main.java.random;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
	
	public static void main(String[] args) {
		
		StringPermutation obj = new StringPermutation();
		System.out.println(obj.permute("ABC"));
	}

	public List<List<String>> permute(String str) {

		List<List<String>> result = new ArrayList<List<String>>();
		if(str == null || str.length() == 0)
			return result;

		List<String> permutations = new ArrayList<>();
		boolean[] visited = new boolean[str.length()];
		helper(str, result, permutations, visited);

		return result;
	}

	private void helper(String str, List<List<String>> result, List<String> permutations, boolean[] visited){

		if(permutations.size() == str.length()){
			result.add(new ArrayList<>(permutations));
			return;
		}

		for(int i=0; i<str.length(); i++){
			if(!visited[i]){
				visited[i] = true;
				permutations.add(String.valueOf(str.charAt(i)));
				helper(str, result, permutations, visited);
				permutations.remove(permutations.size()-1);
				visited[i] = false;
			}

		}
	}
}
