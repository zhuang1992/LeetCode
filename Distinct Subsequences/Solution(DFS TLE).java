//直接暴力搜索会超时
//要用动态规划哦亲
package workbench;

public class Solution {
	int res = 0;
	void dfs(String S, String T, int begin, int st){
		
		if(st == T.length()){
			res++;
			return;
		}			
		for(int i = begin; i < S.length(); i++){
			if(S.charAt(i)==T.charAt(st)){
				dfs(S, T, i+1, st+1);
			}
		}
	}
    public int numDistinct(String S, String T) {
    	dfs(S, T, 0, 0);
    	return res;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	String s = "rabbbit";
    	String t = "rabbit";
    	System.out.println(test.numDistinct(s, t));
    }
}