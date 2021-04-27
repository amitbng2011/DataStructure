package com.technical.test.door;

import java.util.HashSet;
import java.util.Set;

/**
 * return the size of the largest contiguous block (horizontally/vertically connected) of numbers with the same value
 *
 */
public class LargestContiguousBlock {

	public static void main(String[] args) {

		int [][] matrix = new int[][]{
		      {1,1,6},
		      {4,1,9},
		      {5,3,7}
		    };
		LargestContiguousBlock obj = new LargestContiguousBlock();
		System.out.println(obj.largestContiguousBlock(matrix));
	}

	public int largestContiguousBlock(int [][] matrix){

		int row = matrix.length;
		int col = matrix[0].length;
		int max = Integer.MIN_VALUE;
		Set<String> visited = new HashSet<>();
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				max = Math.max(max, findContiguousBlockCount(matrix, i, j, matrix[i][j], visited));
			}
		}

		return max;
	}

	public int findContiguousBlockCount(int [][] matrix, int row, int col, int key, Set<String> visited){


		if(row<0 || row>=matrix.length || col<0 || col>=matrix[0].length || matrix[row][col] != key || visited.contains(row +""+col)){
			return 0;
		}
		int count=1;
		String visit = row +""+col;
		visited.add(visit);
		count += findContiguousBlockCount(matrix, row-1, col, key, visited);
		count += findContiguousBlockCount(matrix, row+1, col, key, visited);
		count += findContiguousBlockCount(matrix, row, col-1, key, visited);
		count += findContiguousBlockCount(matrix, row, col+1, key, visited);

		return count;   
	}
}
