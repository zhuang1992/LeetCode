package workbench;

import java.util.Stack;

public class Solution {
    public int search(int[] A, int target) {
        int low = 0;
        int high = A.length-1;
        int mid;
        while(low<=high){
        	mid = (high+low)>>1;
        	if(A[mid]==target)
        		return mid;
        	if(A[low]==target)
        		return low;
        	if(A[high]==target){
        		return high;
        	}
        	else if(A[mid] > target){
        		if(A[mid]>A[low]){
        			if(target > A[low]){
            			high = mid-1;
            		}else{
            			low = mid+1;
            		}
        		}else{
        			high = mid - 1;
        		}        		
        		
        	}else if(A[mid] < target){
        		if(A[mid] > A[low]){
        			low = mid + 1;
        		}else{
        			if(target > A[high]){
            			high = mid -1;
            		}else{
            			low = mid +1;
            		}
        		}        		
        	}
        }
        return -1;
    }
    public static void main(String[] args){
    	int A[] = {1,2,3,0};
    	Solution test = new Solution();
    	System.out.println(test.search(A, 4));
    }
}