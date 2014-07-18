//注意keyboard是从2开始的
package workbench;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Solution {
    String keyboard[] = {"abc", "def", "ghi", "jkl", "mno","pqrs","tuv","wxyz"};
    StringBuffer singleAns = new StringBuffer();
    List<String> res = new LinkedList<String>();
	void dfs(String digits, int index){
		if(index == digits.length()){
			res.add(singleAns.toString());
			return;
		}
		String temp = keyboard[Integer.valueOf(digits.charAt(index))-'2'];//从2开始
		for(int i = 0; i < temp.length(); i++){
			singleAns.append(temp.charAt(i));
			dfs(digits, index+1);
			singleAns.deleteCharAt(singleAns.length()-1);
		}
	}
    public List<String> letterCombinations(String digits) {
        dfs(digits, 0);
        return res;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	List<String> ans = test.letterCombinations("9");
    	for(int i = 0; i < ans.size(); i++){
    		System.out.println(ans.get(i));
    	}
    }
}