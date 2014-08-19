//ֱ��DFS����TLE��
//����ҪDP
//���Ҿ�Ȼ�Լ�д�������DP�ˣ�����
//O(n^2)���ؼ�Ҫ���������˳��~~
//dp[i][j]��ʾ����i�������ѡ���j���������ܷ�ǡ�ý�s���ײ��
//��Ȼ���������Ҫ�������

//II��I�Ļ����ϼ���һ��dfs��ͨ������dp[i,j]�ɵõ����п������
package workbench;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	boolean dp[][];
    public List<String> wordBreak(String s, Set<String> dict) {
    	this.dict = dict;
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
			for(int b = i; b < s.length()-1; b++){ 	//���forֻ���������Ǹ�for��֮���ٿ�ʼ����Ϊֱ����ʱ��Ҫ�õ���dp��Ϣ���ռ���ɡ�˵���׻������˳�������0��
				if(dp[i][b]==true && dp[b+1][s.length()-1]==true){
					dp[i][s.length()-1] = true;
					break;
				}
			}
		}	
		String t = new String() ;
		findWord(t, 0,s.length()-1, s);
		return rst;
    }
    Set<String>dict;
    List<String>rst = new LinkedList<String>();
    void findWord(String r, int st, int en, String s){
    	if(st > en){
    		rst.add(r.toString().trim());
    		return;
    	}
    	for(int i = st; i <= en; i++ ){
    		if(dp[st][i]==true){
    			if(dict.contains(s.substring(st,i+1))){  //����жϻ����б�Ҫ�ġ�������"leetcode"���ܻᱻ����һ���ʣ���Ϊdp[0][7]==true
    				String t = r + s.substring(st,i+1)+" ";
    				findWord(t, i+1, en, s);
    			}    			
    		}
    	}
    }
    public static void main(String[] args){
    	Solution test =new Solution();
    	Set<String>dict = new HashSet<String>();
    	dict.add("leet");
    	dict.add("code");
    	dict.add("cat");
    	dict.add("cats");
    	dict.add("and");
    	dict.add("sand");
    	dict.add("dog");
    	List<String>r = test.wordBreak("catsanddog", dict);
    	for(int i = 0; i < r.size(); i++){
    		System.out.println(r.get(i));
    	}
    }
}