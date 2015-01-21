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
//Another recursion
public class Solution {
    List<List<Integer>> rst = new LinkedList<List<Integer>>();
    
    void dfs(int[] num, List<Integer> per, int pos){
        if(per.size() == num.length){
            rst.add(new LinkedList<Integer>(per));
            return;
        }
        for(int i = 0; i <= per.size(); i++){
            per.add(i, num[pos]);
            dfs(num, per, pos+1);
            per.remove(i);
        }
    }
    
    public List<List<Integer>> permute(int[] num) {
        dfs(num, new LinkedList<Integer>(), 0);
        return rst;
    }
}


//Iteration
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        LinkedList<List<Integer>> rst = new LinkedList<List<Integer>>();
        if(num == null || num.length == 0)
            return rst;
        rst.add(new LinkedList<Integer>());//rst=[[]];
        for(int i = 0; i < num.length; i++){
            int cnt = rst.size();
            while(cnt-- > 0){
                List<Integer> item = rst.getFirst();
                for(int k = 0; k <= item.size(); k++){
                    item.add(k,num[i]);
                    rst.add(new LinkedList<Integer>(item));
                    item.remove(k);
                }
                rst.removeFirst();
            }
        }
        return rst;
    }
}