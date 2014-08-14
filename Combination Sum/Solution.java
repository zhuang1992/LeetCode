
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    int candidates[];
    List<List<Integer>> rst = new LinkedList<List<Integer>>();
    void dfs(List<Integer>t, int st, int target){
    	if(target == 0){
    		rst.add(t);
    		return;
    	}
    	for(int i = st; i < candidates.length; i++){
    		if(target >= candidates[i]){
    			List<Integer> tt = new LinkedList<Integer>(t);        		
        		tt.add(candidates[i]);        		
        		dfs(tt, i, target - candidates[i]); //这是II和I唯一的区别。如果是i，那么一个数可以用多次，如果是i+1，则每个数只能被用一次。
        		i++;
        		while(i < candidates.length && candidates[i] == candidates[i-1]) // skip the duplicates
        			i++;
        		i--; //at the end of For-Loop, i will increase by 1 again.
    		}else
    			return;    		//pruning
    	}
    }
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
        this.candidates = candidates;
        List<Integer>t = new LinkedList<Integer>();
        dfs(t, 0, target);
        return rst;
    }
	public static void main(String[] args){
		Solution test = new Solution();
		int c[] = {2,3,6,7};
		List<List<Integer>>r = test.combinationSum(c, 7);
		for(int i = 0; i < r.size(); i++){
			for(int j = 0; j < r.get(i).size(); j++){
				System.out.print(r.get(i).get(j));
			}
			System.out.print('\n');
		}
	}
}