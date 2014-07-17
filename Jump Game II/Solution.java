//jump game I只需找到一条可行解就返回true，因此从右往左找比较快
//而jump game II需要找到一条最短的跳法，因此先从左往右找，找到能跳到target的最靠左的那个点p，然后递归找能跳到点p的最靠左的点。
//如果能找到，即target成为0，则返回跳的步数。如果不能，则返回上一层，继续往右找。
package workbench;

import java.util.*;
public class Solution {
	int dfs(int[] A, int target){
		if(target == 0){
			return 0;
		}
		for(int i = 0; i <target; i++){
    		if(A[i] >= target - i){
    			int  t = dfs(A, i);
    			if(t!=-1){
    				return t+1;
    			}
    		}
    	}
		return -1;
	}
    public int jump(int[] A) {
        int len = A.length;
    	return dfs(A, len-1);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int A[] = {2,3,1,1,4};
    	System.out.print(test.jump(A));
    }
}