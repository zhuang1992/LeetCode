//直接DFS还是TLE了
//还是要DP
//啊我居然自己写出来这个DP了！！！
//O(n^2)，关键要搞好填矩阵的顺序啊~~
//dp[i][j]表示：从i往后，如果选择从j处劈开，能否恰好将s彻底拆分
//显然填这个矩阵，要倒着来填。

//II在I的基础上加了一个dfs，通过搜索dp[i,j]可得到所有可能组合
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
			for(int b = i; b < s.length()-1; b++){ 	//这个for只能在上面那个for完之后再开始，因为直到这时需要用到的dp信息才收集完成。说到底还是填表顺序决定的0。
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
    			if(dict.contains(s.substring(st,i+1))){  //这个判断还是有必要的。否则如"leetcode"可能会被当成一个词，因为dp[0][7]==true
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