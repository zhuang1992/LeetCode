package workbench;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	List<List<Integer>> res = new LinkedList<List<Integer>>();
	void dfs(int n, int k, List<Integer>cur){
		if(k==0){
			res.add(new LinkedList<Integer>(cur));
			return;
		}
		
		for(int i = cur.get(cur.size()-1)+1; i <= n; i++){
        	cur.add(i);
        	dfs(n,k-1,cur);
        	cur.remove(cur.size()-1);
		}	
	}
    public List<List<Integer>> combine(int n, int k) {
    	List<Integer>cur = new LinkedList<Integer>();
    	for(int i = 1; i <= n; i++){
			cur.add(i);
    		dfs(n,k-1,cur);
    		cur.remove(cur.size()-1);
		}
        return res;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	List<List<Integer>> r = test.combine(10, 5);
    	for(int i = 0; i < r.size(); i++){
    		System.out.println(r.get(i));
    	}
    }
}