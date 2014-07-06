package workbench;
public class Solution {
    int binarySearch(int[] A, int target,int low, int high){
    	int mid = (low+high)/2;
    	if(A[low]==A[mid]){
    		if(A[low]==target)
    			return low;
    		if(A[high]==target)
    			return high;
    		return -1;
    	}
    	if(A[low]<A[mid]){
    		if(A[mid]<target){
    			return binarySearch(A,target,mid+1,high);
    		}else if(A[mid]>target){
    			if(A[low]>target){
    				return binarySearch(A,target,mid+1,high);
    			}else if(A[low]<target){
    				return binarySearch(A,target,low,mid-1);
    			}else
    				return low;
    		}else
    			return mid;
    	}else if(A[low] >A[mid]){
    		if(A[mid]>target){
    			return binarySearch(A,target,low,mid-1);
    		}else if(A[mid]<target){
    			if(A[low]>target){
    				return binarySearch(A,target,mid+1,high);
    			}else if(A[low]<target){
    				return binarySearch(A,target,low,mid-1);
    			}else
    				return low;
    		}else 
    			return mid;
    	}
    	if(A[mid]==target)return mid;
		return -1;
    }
	public int search(int[] A, int target) {
            return binarySearch(A,target,0,A.length-1); 
    }
	public static void main(String[] args){
		Solution test = new Solution();
		int[] A = {1};
		System.out.println(test.search(A, 3));
	}
}