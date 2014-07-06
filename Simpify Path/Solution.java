//使用栈
package workbench;

import java.util.Stack;


public class Solution {
    public String simplifyPath(String path) {
    	Stack<String> S = new Stack<String>();
        String[] items = path.split("/");
        int cnt = 0;
        for(int i = 0; i < items.length; i++){
        	if(items[i].equals(".") || items[i].length()==0){
        		continue;
        	}else if(items[i].equals("..")){
        		S.pop();
        		continue;
        	}
        	S.push(items[i]);
        }
        StringBuffer res = new StringBuffer();
        if(S.isEmpty())
        	return "/";
        while(!S.isEmpty()){
        	res.insert(0,"/"+S.pop());  	
        }
        return res.toString();
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	String path="/home/";
    	System.out.println(test.simplifyPath(path));
    }
}