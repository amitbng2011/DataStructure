package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {

		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		SpiralMatrix obj = new SpiralMatrix();
		List<Integer> res = obj.spiralOrder(matrix);
		System.out.println(res);
	}

	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> res = new ArrayList<Integer>();
		int top = 0;
		int bottom = matrix.length-1;
		
		int left = 0;
		int right = matrix[0].length-1;
		
		while(true) {
			
			for(int i=left; i<=right; i++)
				res.add(matrix[top][i]);
			top++;
			
			if(left>right || top>bottom)
				break;
			
			for(int i=top; i<=bottom; i++)
				res.add(matrix[i][right]);
			right--;
			
			if(left>right || top>bottom)
				break;
			
			for(int i=right; i>=left; i--)
				res.add(matrix[bottom][i]);
			bottom--;
			
			if(left>right || top>bottom)
				break;
			
			for(int i=bottom; i>=top; i--)
				res.add(matrix[i][left]);
			left++;
			
			if(left>right || top>bottom)
				break;
		}
		
		return res;
	}
}