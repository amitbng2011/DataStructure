package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *   
 * Note: You may not slant the container and n is at least 2.
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 * @author amit
 *
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int a[] = {1,8,6,2,5,4,8,3,7}; 
        int b[] = {3, 1, 2, 4, 5}; 
        
        System.out.print( maxArea(a)+"\n" ); 
      
        System.out.print( maxArea(b) ); 
        
	}
	private static int maxArea(int[] height) {
		
		int i=0;
		int j = height.length-1;
		int area = 0;
		
		while(i<j) {
			area = Math.max(area, Math.min(height[i], height[j]) * (j-i));
			
			if(height[i]<height[j])
				i++;
			else
				j--;
		}
		
		return area;
	}
}
