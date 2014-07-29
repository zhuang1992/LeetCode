package workbench;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer>singleRes = new LinkedList<Integer>();
        if(S.length == 0)
        	return res;
        Arrays.sort(S);
       // singleRes.add(null);
        res.add(singleRes);
        for(int s = 0; s < S.length; s++){       
        	int resSize = res.size();
        	for(int i = 0; i < resSize; i++){
        		singleRes = new LinkedList(res.get(i));
        		singleRes.add(S[s]);        		
        		res.add(singleRes);
        	}        	
        }
        return res;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int S[] = {1,2,3};
    	List<List<Integer>> r = test.subsets(S);
    	for(int i = 0; i < r.size(); i++){
    		System.out.println(r.get(i));
    	}
    }
}