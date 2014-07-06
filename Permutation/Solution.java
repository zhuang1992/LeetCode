package workbench;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
	void dfs(List<Integer>list, int num[],boolean visited[]){
    	if(list.size() == num.length){
    		List<Integer>t = new ArrayList<Integer>(list);
    		res.add(t);
    		return;
    	}
    	for(int i = 0; i < num.length; i++){
    		if(visited[i]==false){
    			list.add(num[i]);
    			visited[i] = true;
    			dfs(list,num,visited);
    			visited[i] = false;
    			list.remove(list.size()-1);
    		}
    	}
    }
	public List<List<Integer>> permute(int[] num) {
        List<Integer> list = new ArrayList<Integer>();
        boolean visited[] = new boolean[num.length];
        dfs(list,num,visited);
        return res;
    }
	public static void main(String[] args){
		int num[]={1,2,3};
		Solution test = new Solution();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = test.permute(num);
		//System.out.println(res.size());
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++){
				System.out.print(res.get(i).get(j));
			}
			System.out.println("");
		}
	}
}