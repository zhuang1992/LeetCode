//递推条件设为S前i个字符通过删除字符得到T前j个字符的转换方法
//这个角度万万没想到，edit distance变种么
package workbench;

public class Solution {
	int dp[][];
	public int numDistinct(String S, String T) {
    	if(S.length() == 0 || T.length() == 0)
    		return 0;
		dp = new int[S.length()+1][T.length()+1];
		for(int i = 0; i <= S.length(); i++){
			dp[i][0] = 1;
		}
		
		for(int i = 1; i <= S.length(); i++){
			for(int j = 1; j <= T.length(); j++){
				if(S.charAt(i-1)==T.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[S.length()][T.length()];
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	String s = "rabbbit";
    	String t = "rabbit";
    	System.out.println(test.numDistinct(s, t));
    }
}