//逆推，只需要找到一个可行解，返回true就行
package workbench;
public class Solution {
	boolean dfs(int [] T, int len){
		if(len == 1)
			return true;
		for(int i = len - 2; i >= 0; i--){
        	if(T[i] >= len-1-i){
        		return dfs(T, i+1);  //这个地方可以直接return，有点意思。
        									//可以这么想，如果连这个T[i]都到不了，就肯定到不了最后一个了，直接返回false就行，不必再尝试更往前(更小的i)了。
        	}
        }
		return false;
	}
    public boolean canJump(int[] A) {
        return dfs(A, A.length);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int A[] = {2,1,0,1,4};
    	System.out.println(test.canJump(A));
    }
}