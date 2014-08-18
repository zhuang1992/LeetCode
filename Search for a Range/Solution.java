//直接二分，找到后向两边扩展找边界。
package workbench;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int low = 0;
        int high = A.length-1;
        int rst[] = new int[2];
        rst[0] = -1; rst[1] = -1;
        while(low <= high){
        	int mid = (low+high)>>1;
        	if(A[mid]==target){
        		rst[0] = mid;
        		while(rst[0] >=0 && A[rst[0]]==target)
        			rst[0]--;
        		if(rst[0] < 0 || A[rst[0]]!=target)
        			rst[0]++;
        		rst[1] = mid;
        		while(rst[1] < A.length && A[rst[1]]==target)
        			rst[1]++;     
        		if(rst[1] >=A.length || A[rst[1]]!=target)
        			rst[1]--;
        		break;
        	}else if(A[mid] < target){
        		low = mid + 1;
        	}else{
        		high = mid - 1;
        	}
        }
        return rst;
    }
    public static void main(String[] args){
    	int A[] = {5, 7, 7, 8, 8, 10};
    	Solution test = new Solution();
    	int rst[] = test.searchRange(A, 5);
    	System.out.print(rst[0]+" "+rst[1]);
    }
}