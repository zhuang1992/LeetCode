//参考了网上另一种求permutation的方法
//dfs求permutation效率并不高，这里采用一种迭代的方法
//
package workbench;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    Set<List<Integer>> repo = new HashSet<List<Integer>>();
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Set<List<Integer>> tempRes = new HashSet<List<Integer>>();
	List<Integer> temp;
	public List<List<Integer>> permuteUnique(int[] num) {
		//res.add(null);
        for(int i = 0; i < num.length; i++){
        	if(res.size()==0){
        		temp = new LinkedList<Integer>();
        		temp.add(num[i]);
        		res.add(temp);
        		continue;
        	}
        	for(int j = 0; j < res.size(); j++){
        		for(int k = 0; k <= res.get(j).size(); k++){
        			temp = new LinkedList<Integer>(res.get(j));
        			temp.add(k,num[i]);
        			tempRes.add(temp);
        		}
        	}
        	res = new LinkedList<List<Integer>>(tempRes);
        	tempRes.clear();
        	
        }
        return res;
    }
	public static void main(String[] args){
		int num[]={1,1,2,1};
		Solution test = new Solution();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = test.permuteUnique(num);
		//System.out.println(res.size());
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++){
				System.out.print(res.get(i).get(j));
			}
			System.out.println("");
		}
	}
}