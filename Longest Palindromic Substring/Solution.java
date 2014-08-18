//��Ȼ����ǰ������ӡ�󣬵�Ҳ�����д�����˰�
//dp[i,j] = dp[i+1,j-1], if s[i]==s[j]  
//dp[i,j] = false, others
//ע��߽����
//�����ĵ��Ʒ��̾��������������Ĵ���
//��������ʵ�������ټ��һ��
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
    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int st = -1;
        int en = -1;
        int maxL = -1;
        for(int i = s.length()-1; i>=0; i--){
        	for(int j = i; j < s.length(); j++){
        		if(j - i < 2){
        			if(s.charAt(i)==s.charAt(j))
        				dp[i][j] = true;
        			else 
        				dp[i][j] = false;
        		}else	if(dp[i+1][j-1]==true && s.charAt(i)==s.charAt(j)){
        			dp[i][j] = true;
        		}else{
        			dp[i][j] = false;
        		}
        		if(dp[i][j] == true && maxL < j - i +1){
        			maxL = j-i+1;
        			st = i;
        			en = j;
        		}
        	}
        }
        return s.substring(st, en+1);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.print(test.longestPalindrome("aabcbaab"));
    }
}