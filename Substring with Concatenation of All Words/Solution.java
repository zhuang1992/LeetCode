//�Զ������ֱ������word break��ĺ��������Ӷ�ΪO(m^2)��m��L�������ַ����ĳ��Ⱥ�
//��S��ͷ��β����һ�飬�����ܵĸ��Ӷ���O(n*m^2)��n��S�ĳ���
//��Ȼ��ʱ��
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
	Set<String>dict = new HashSet<String>();
	boolean dp[][];
	public boolean wordBreak(String s) {
		dp = new boolean[s.length()][s.length()];
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
			for(int b = i; b < s.length()-1; b++){
				if(dp[i][b]==true && dp[b+1][s.length()-1]==true){
					dp[i][s.length()-1] = true;
					break;
				}
			}
		}
		return dp[0][s.length()-1];
    }
	
   public List<Integer> findSubstring(String S, String[] L) {
	   List<Integer>rst = new LinkedList<Integer>();
	   int len = 0;
	    for(String t : L){
	    	len += t.length();
	    	dict.add(t);
	    }
	    for(int i = 0; i < S.length()-len; i++){
	    	if(wordBreak(S.substring(i,i+len))==true){
	    		rst.add(i);
	    	}
	    }
	    return rst;
   }
	public static void main(String[] args){
		String L[] = {"foo","bar"};
		Solution test = new Solution();
		List<Integer> r = test.findSubstring("barfoothefoobarman", L);
		for(Integer i : r)
			System.out.println(i);
	}
}