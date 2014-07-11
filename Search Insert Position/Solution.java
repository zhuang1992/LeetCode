//二分查找。注意没有重复元素。
package workbench;
public class Solution {
    public int searchInsert(int[] A, int target) {
        int len = A.length;
    	int low = 0;
        int high = len - 1;
        while(low <= high){
        	int mid = (low + high) / 2;
        	if(A[mid] == target){
        		return mid;
        	}
        	if(mid == low){
        		if(target < A[mid])
        			return mid;
        		else{
        			while(A[mid] <= target ){
        				mid ++;
        				if(mid >= A.length)
        					return A.length;
        				if(A[mid] == target)
        					return mid;
        			}
        			return mid;
        		}
        	}
        	if(A[mid] < target){
        		low = mid;
        	}else{
        		high = mid;
        	}
        }
        return  -1;
    }
    public static void main(String[] args){
    	int A[] = {1};
    	Solution test = new Solution();
    	System.out.println(test.searchInsert(A, 2));
    }
}