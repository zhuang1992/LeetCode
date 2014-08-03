package workbench;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
    	Stack<Character>S = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
        	switch(s.charAt(i)){
        	case '(':
        		S.push(s.charAt(i));
        		break;
        	case '[':
        		S.push(s.charAt(i));
        		break;
        	case '{':
        		S.push(s.charAt(i));
        		break;
        	case ')':
        		if(!S.isEmpty() && S.peek().equals('(')){
        			S.pop();
        		}else
        			return false;
        		break;
        	case ']':
        		if(!S.isEmpty() && S.peek().equals('[')){
        			S.pop();
        		}else
        			return false;
        		break;
        	case '}':
        		if(!S.isEmpty() && S.peek().equals('{')){
        			S.pop();
        		}else
        			return false;
        		break;
        	default:
        		return false;
        	}
        }
        if(S.isEmpty())
        	return true;
        return false;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	String s = "(";
    	System.out.print(test.isValid(s));
    }
}