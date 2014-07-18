//注意皇后可以走对角线
package workbench;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Solution {
	boolean used[];
	List<String[]> res = new LinkedList<String[]>();
	LinkedList<Integer> singleAns = new LinkedList<Integer>();
	boolean check(int row, int col, int n, LinkedList<Integer> sa){  //检查对角线上是否有冲突
		for(int i = 0; i < sa.size(); i++){
			if(i + 1 == Math.abs(col - sa.get(sa.size() -1-i)) ){
				return false;
			}
		}
		return true;
	}
	void dfs(int n, int cnt){
		if(cnt==n){
			makeRes(singleAns, n);
		}
		for(int i = 0 ; i < n; i++){
			if(used[i]==false && check(cnt, i, n, singleAns)){
				
				used[i] = true;
				singleAns.add(i);
				dfs(n,cnt+1);
				singleAns.removeLast();
				used[i] = false;
			}
		}
	}
	void makeRes(LinkedList<Integer> r, int n){
		String[] temp = new String[n];
		StringBuffer ts = new StringBuffer(n);
		int linecnt = 0;
		for(int i = 0; i < n; i++){
			ts.append('.');
		}
		for(int i = 0; i < r.size(); i++){
			ts.replace(r.get(i), r.get(i)+1, "Q");
			temp[linecnt++] = ts.toString();
			ts.replace(r.get(i), r.get(i)+1, ".");
		}
		res.add(temp);		
	}
    public List<String[]> solveNQueens(int n) {
        used = new boolean[n];
        dfs(n,0);
        return res;
    }
    public static void main(String[] args){    	
    	Solution test = new Solution();
    	List<String[]> a = test.solveNQueens(4);
    	for(int i = 0; i < a.size(); i++){
    		for(int j = 0; j < a.get(i).length; j++){
    			System.out.println(a.get(i)[j]);
    		}
    		System.out.print("\n");
    	}
    }
}