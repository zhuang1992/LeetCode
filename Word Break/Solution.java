//直接DFS还是TLE了
//还是要DP
//啊我居然自己写出来这个DP了！！！
//O(n^2)，关键要搞好填矩阵的顺序啊~~
//dp[i][j]表示：从i往后，如果选择从j处劈开，能否恰好将s彻底拆分
//显然填这个矩阵，要倒着来填。
package workbench;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
		boolean dp[][] = new boolean[s.length()][s.length()];
		for(int i = s.length()-1; i >= 0; i--){
			for(int j = s.length()-1; j >=i; j--){
				if(dict.contains(s.substring(i,j+1))){
					if(j == s.length()-1){
						dp[i][j] = true;
					}else{
						dp[i][j] = dp[j+1][s.length()-1];
					}
				}else{
					dp[i][j] = false;
				}					
			}
			for(int b = i; b < s.length()-1; b++){ 	//这个for只能在上面那个for完之后再开始，因为直到这时需要用到的dp信息才收集完成。说到底还是填表顺序决定的0。
				if(dp[i][b]==true && dp[b+1][s.length()-1]==true){
					dp[i][s.length()-1] = true;
					break;
				}
			}
		}
		
		return dp[0][s.length()-1];
    }
    public static void main(String[] args){
    	Solution test =new Solution();
    	Set<String>dict = new HashSet<String>();
    	dict.add("leet");
    	dict.add("code");
    	System.out.print(test.wordBreak("leetscode", dict));
    }
}