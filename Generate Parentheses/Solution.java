package workbench;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<String> res = new ArrayList<String>();
    void dfs(String s,int numFirst, int numLast){
    	if(numFirst>0){
    		dfs(s+'(',numFirst-1,numLast);
    	}    	
    	if(numFirst<numLast){
    		dfs(s+')',numFirst,numLast-1);
    	}
    	if(numFirst==0 && numLast==0){
    		res.add(s);
    	}
    }
	public List<String> generateParenthesis(int n) {
        String t="";
        dfs(t,n,n);
        return res;
    }
	public static void main(String[] args){
		Solution test = new Solution();
		List<String>r = test.generateParenthesis(2);
		for(int i = 0; i < r.size(); i++){
			System.out.println(r.get(i));
		}		
	}
}