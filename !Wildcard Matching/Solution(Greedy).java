//ֱ��DFS��Ȼ��ʱ��С��֦һ�£��н���������TLE��
//����˵�������̰�ģ�����
//��ͷ������DP��
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
    			rs = ps;  // *�ȳ���ƥ��մ�
    			continue;
    		}
    		//������е��⣬˵���޷�ƥ����ȥ�ˣ���Ҫ����
    		if(star != -1){		//���ǰ����ֹ�*���ͻ��оȡ�����������̰��˼�룬��������Ǹ�*���Ⱦ��С�
    								//DFSʱҲ������������Ǹ�*���ȣ�����Ȳ��ɣ��ǾͿ���ֱ��return false����������ǰ���ˡ��ſ���������dfs������֦��
    			pp = star + 1;  //reset the position of pp ���ƻ���
    			ps = rs + 1;  // *���Զ�ƥ��һ���ַ�
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