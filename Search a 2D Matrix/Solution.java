//两次二分查找
package workbench;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {    
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0)
        	return false;
        int m = matrix[0].length;
        int low = 0;
        int high = n-1;
        
        int targetRow=-1;
        while(low <= high){
        	int mid = (low+high)/2;
        	if(mid == n-1){
        		if(matrix[mid][0]<=target){
            		targetRow = mid;
        		}
        		break;
        	}else if(matrix[mid][0]==target){
        		return true;
//        		targetRow = mid;
//        		break;
        	}else if(matrix[mid][0] > target){
        		high = mid-1;
        	}else if(matrix[mid][0] < target && matrix[mid+1][0] > target){
        		targetRow = mid;
        		break;
        	}else{
        		low = mid +1;
        	}        		
        }
        if(targetRow==-1)
        	return false;
        low = 0;
        high = m-1;
        
        while(low<=high){
        	int mid = (low+high)/2;
        	if(matrix[targetRow][mid]==target){
        		return true;
        	}else if(matrix[targetRow][mid] >target){
        		high = mid-1;
        	}else if(matrix[targetRow][mid] < target){
        		low = mid+1;
        	}
        }
        return false;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int m[][]={
    	           {1,   3,  5,  7},
    	           {10, 11, 16, 20},
    	           {23, 30, 34, 50}
    	};
    	System.out.print(test.searchMatrix(m,333));
    }
}