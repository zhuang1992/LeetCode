//直接DFS果然超时。小剪枝一下，有进步但还是TLE。
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
		if(s.length() == s1){
			for(int i = p1; i < p.length(); i++){
				if(p.charAt(i)!='*')
					return false;
			}
			return true;
		}
		if(p.length() == p1){
			if(s.length()==s1)
				return true;
			return false;
		}
			
		boolean temp = false;
		if(s.charAt(s1) == p.charAt(p1) || p.charAt(p1)=='?'){
			 temp = dfs(s, s1+1, p, p1+1);
			 if(temp == true)
				 return true;
		}
		
		if(p.charAt(p1)=='*'){
			if(p1>0 && p.charAt(p1-1)=='*')  //连续的*可以忽略之，算剪枝吧
				return false;
			for(int i = s1-1; i < s.length(); i++){  //从s1-1开始，以便下面i+1是从s1开始，也就是*可以匹配空串
				temp = dfs(s, i+1, p, p1+1);     //枚举一个'*'能覆盖多少s中的字符
				if(temp==true)
					return true;
			}
		}
		return false;
	}
    public boolean isMatch(String s, String p) {
    	return dfs(s,0,p,0);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.println(test.isMatch("bbb", "*b"));
    	System.out.println(test.isMatch("aa", "a"));
    	System.out.println(test.isMatch("aa", "aa"));
    	System.out.println(test.isMatch("aaa", "aa"));
    	System.out.println(test.isMatch("aa", "*"));
    	System.out.println(test.isMatch("aa", "a*"));
    	System.out.println(test.isMatch("ab", "?*"));
    	System.out.println(test.isMatch("aab", "c*a*b"));
    	System.out.println(test.isMatch("b", "*?*?"));
    	System.out.println(test.isMatch("b", "*?*?*"));
    	System.out.println(test.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
    }
}