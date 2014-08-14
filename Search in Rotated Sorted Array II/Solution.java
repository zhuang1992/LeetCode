//这个方法比较简单粗暴，但是好理解
package workbench;

import java.util.Stack;

public class Solution {
	boolean biSearch(int[] A, int low, int high, int target){
		if(low>high)
			return false;
		int mid = (high+low)>>1;
		if(A[mid]==target){
			return true;
		}else	if(A[low] < A[high]){
			return A[mid]>target?biSearch(A,low,mid-1,target):biSearch(A,mid+1,high,target);//如果数组是正常递增序(没有rotate)，直接普通二分查找
		}else{
			return biSearch(A,low,mid-1,target) || biSearch(A,mid+1,high,target); //关键在此。如果数组是rotated，别墨迹，干脆两边都搜。时间复杂度上升。
		}
	}
    public boolean search(int[] A, int target) {
        return biSearch(A,0,A.length-1,target);
    }
    public static void main(String[] args){
    	int A[] = {1,3,1,1,1};
    	Solution test = new Solution();
    	System.out.println(test.search(A, 3));
    }
}