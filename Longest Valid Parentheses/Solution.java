//不要异想天开想什么O(n)的算法，总有考虑不到的情况。发现反例再去修改程序，又会顾此失彼。
//直接上DP
//dp[i] 表示以s[i]结尾的子串最长的有效括号长度(求子串的DP大都如此)
package workbench;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
    	int dp[] = new int[s.length()];
    	int rst = 0;
    	for(int i = 1; i < s.length(); i++){
    		if(s.charAt(i) == ')'){
    			if(i >= dp[i-1]+1){
    				if(s.charAt(i-dp[i-1]-1)=='('){
    					dp[i] = dp[i-1] + 2;
    				}
    			}    		
    			if(i >= dp[i]){
    				dp[i] += dp[i-dp[i]];
    			}
    		}else if(s.charAt(i)==')'){
    			dp[i] = 0;
    		}
    		rst = Math.max(rst, dp[i]);
    	}
        return rst;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.println(test.longestValidParentheses("())"));
    	System.out.println(test.longestValidParentheses("(()()"));
    	System.out.println(test.longestValidParentheses("(()"));
    	System.out.println(test.longestValidParentheses("()(()"));
    	System.out.println(test.longestValidParentheses(")()())"));
    	System.out.println(test.longestValidParentheses("(()(((()"));
    }
}