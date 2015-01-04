package workbench;

public class Solution {
    public int maxProduct(int[] A) {
        if(A.length==0)
        	return 0;
        if(A.length==1)
        	return A[0];
        int dp[][] = new int[A.length+1][2];
        int res = A[0];
        for(int i = 1; i <= A.length; i++){
        	if(i==1){
        		if(A[i-1]>0){
        			dp[i][0] = A[i-1];
        		}else if(A[i-1]<0){
        			dp[i][1] = A[i-1];
        		}
        		continue;
        	}        		
        	if(A[i-1] > 0){
        		dp[i][0] = Math.max(A[i-1],dp[i-1][0]*A[i-1]);
        		dp[i][1] = dp[i-1][1]*A[i-1];
        	}else if(A[i-1] < 0){
        		dp[i][0] = dp[i-1][1]*A[i-1];
        		dp[i][1] = Math.min(A[i-1],dp[i-1][0]*A[i-1]);
        	}else{
        		dp[i][0] = 0;
        		dp[i][1] = 0;
        	}
        	res = Math.max(dp[i][0], res);
        }
        return res;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int a[] = {-3,-2};
    	System.out.println(test.maxProduct(a));
    }
}