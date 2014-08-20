//直接DFS果然超时。小剪枝一下，有进步但还是TLE。
//网上说这题可以贪心，试试
//回头再试试DP吧
package workbench;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public boolean isMatch(String s, String p) {
    	int star=-1;
    	int rs=-1;
    	int ps = 0;
    	int pp = 0;
    	while(ps < s.length()){
    		if(pp < p.length() && (s.charAt(ps) == p.charAt(pp) || p.charAt(pp)=='?')){
    			ps++;
    			pp++;
    			continue;
    		}
    		if(pp < p.length() && p.charAt(pp)=='*'){
    			star = pp;
    			pp++;
    			rs = ps;  // *先尝试匹配空串
    			continue;
    		}
    		//如果运行到这，说明无法匹配下去了，需要回溯
    		if(star != -1){		//如果前面出现过*，就还有救。这里体现了贪心思想，用最近的那个*来救就行。
    								//DFS时也是先用最近的那个*来救，如果救不成，那就可以直接return false，不用再往前找了。嗯可以这样给dfs来剪个枝。
    			pp = star + 1;  //reset the position of pp 类似回溯
    			ps = rs + 1;  // *尝试多匹配一个字符
    			rs ++;
    			continue;
    		}
    		return false;
    	}
    	while(pp < p.length() && p.charAt(pp)=='*')pp++;
    	return pp==p.length()?true:false;
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