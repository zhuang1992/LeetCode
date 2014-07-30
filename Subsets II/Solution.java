package workbench;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
		List<Integer> singleRes = new LinkedList<Integer>();
        if(num.length == 0)
        	return res;
		Arrays.sort(num);
		res.add(singleRes);
		int newnum = 0;
		for(int s = 0; s < num.length; s++){
			int resSize = res.size();
			int updateStart = (s>0 && num[s] == num[s-1])?res.size()-newnum:0;  //避免出现重复，这个逻辑很重要。
			
			for(int i = updateStart; i < resSize; i++){
				singleRes = new LinkedList<Integer>(res.get(i));					
				singleRes.add(num[s]);
				res.add(singleRes);
			}
			if(updateStart ==0)
				newnum = resSize;	
		}        
		return res;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int S[] = {2,2,2,2,2};
    	List<List<Integer>> r = test.subsetsWithDup(S);
    	for(int i = 0; i < r.size(); i++){
    		System.out.println(r.get(i));
    	}
    }
}