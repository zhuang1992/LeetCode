//ֱ��DFS����TLE��
//����ҪDP
//���Ҿ�Ȼ�Լ�д�������DP�ˣ�����
//O(n^2)���ؼ�Ҫ���������˳��~~
//dp[i][j]��ʾ����i�������ѡ���j���������ܷ�ǡ�ý�s���ײ��
//��Ȼ���������Ҫ�������
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
			for(int b = i; b < s.length()-1; b++){ 	//���forֻ���������Ǹ�for��֮���ٿ�ʼ����Ϊֱ����ʱ��Ҫ�õ���dp��Ϣ���ռ���ɡ�˵���׻������˳�������0��
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