//事实证明，写新题不要在相似的题目上改。。。
//在wildcard matching基础上改了半天都是错。。本来比那题还简单的。都不(能)用贪心剪枝。。
//只能借用思想，不能借用代码。
package workbench;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	boolean dfs(String s, int s1, String p, int p1){
		if(p1 >= p.length()){
			return s1==s.length();
		}	
		if(p1+1 < p.length() && p.charAt(p1+1)=='*'){
			while(s1 < s.length() && (p.charAt(p1)=='.' || p.charAt(p1)==s.charAt(s1))){
				if(dfs(s, s1, p, p1+2))
					return true;
				s1++;
			}
			return dfs(s, s1, p, p1+2);  //*匹配空串
		}else if(s1<s.length() && (s.charAt(s1) == p.charAt(p1) || p.charAt(p1)=='.')){
			 if(dfs(s, s1+1, p, p1+1))
				 return true;
		}
		return false;
	}
    public boolean isMatch(String s, String p) {
    	return dfs(s,0,p,0);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.println(test.isMatch("bbbba", ".*a*a"));
    	System.out.println(test.isMatch("ab", ".*c"));
    	System.out.println(test.isMatch("a", "ab*"));
    	System.out.println(test.isMatch("aaa", ".*"));
    	System.out.println(test.isMatch("abcd", "d*"));
    	System.out.println(test.isMatch("aa", "a"));
    	System.out.println(test.isMatch("aa", "aa"));
    	System.out.println(test.isMatch("aaa", "aa"));
    	System.out.println(test.isMatch("aa", "a*"));
    	System.out.println(test.isMatch("ab", ".*"));
    	System.out.println(test.isMatch("aab", "c*a*b"));
    	System.out.println(test.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
    }
}