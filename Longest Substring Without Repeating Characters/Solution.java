//哦哦自己做出来的DP！
//dp[i]表示以第i个字符结尾的substring
package workbench;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if(s.length() == 0)
			return 0;
        int[] dp = new int[s.length()+1];
        for(int i = 1; i <= s.length(); i++){
        	if(i == 1)
        		dp[i] = 1;
        	for(int z = i-dp[i-1]; z < i; z++){
        		if(s.charAt(z-1)==s.charAt(i-1)){  //利用dp[i-1]可以求dp[i]
        			dp[i] = i-z;
        			break; //已知在dp[i-1]中是没有重复的，所以找到第一个与s(i)相同的字符，就可以break了。
        		}else{
        			dp[i] = dp[i-1]+1;
        		}
        	}        		
        }
        int rst = -1;
        for(int i = 1; i <= s.length(); i++){
        	rst = rst<dp[i]?dp[i]:rst;
        }
        return rst;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.print(test.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
    }
}