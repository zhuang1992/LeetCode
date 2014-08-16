//dp[i,j] = min(dp[i-1,j]+1,dp[i,j-1]+1,dp[i-1,j-1]+1), if s[i]!=s[j]
//dp[i,j] = min(dp[i-1,j]+1, dp[i,j-1]+1, dp[i-1,,j-1]), if s[i[==s[j]		
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
    int dp[][];
	public int minDistance(String word1, String word2) {
		if(word1.length()==0 || word2.length()==0)
			return word1.length()==0?word2.length():word1.length();
        dp = new int[word1.length()+1][word2.length()+1];
        for(int  i = 0; i <= word1.length(); i++){
        	dp[i][0] = i;
        }
        for(int j = 0; j <= word2.length(); j++){
        	dp[0][j] = j;
        }
        for(int i = 1; i <= word1.length(); i++){
        	for(int j = 1; j <= word2.length(); j++){
        		if(word1.charAt(i-1)==word2.charAt(j-1)){
        			dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]));
        		}else{
        			dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+1));        				
        		}
        	}
        }
        return dp[word1.length()][word2.length()];
    }
	public static void main(String[] args){
		Solution test = new Solution();
		System.out.print(test.minDistance("sea","eat"));
	}
}