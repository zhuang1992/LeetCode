//直接搜可能会TLE
//记忆化搜索哦~
//下次试试DP
package workbench;

import java.util.*;
public class Solution {
	int memStep[];
	int memoizeDFS(int n){
		if(n<=0)
			return 0;
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(memStep[n]!=-1)
			return memStep[n];
		memStep[n] = memoizeDFS(n-2)+memoizeDFS(n-1);
		return memStep[n];
	}
    public int climbStairs(int n) {
    	memStep = new int[n+1];
    	for(int i = 0; i <= n; i++){
    		memStep[i] = -1;
    	}
    	return memoizeDFS(n);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.println(test.climbStairs(4));
    }
}