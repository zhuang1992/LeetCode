package workbench;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>S = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
        	if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/") ){
        		int n1,n2;
        		n1 = S.pop();
        		n2 = S.pop();
        		switch (tokens[i]){
            	case "+":
            		S.push(n2+n1);
            		break;
            	case "-":
            		S.push(n2-n1);
            		break;
            	case "*":
            		S.push(n2*n1);
            		break;
            	case "/":
            		S.push(n2/n1);
            		break;
            	}
        	}else{
        		try{
        			S.push(Integer.parseInt(tokens[i]));
        		}catch(NumberFormatException e){
        			;
        		}
        		
        	}        	
        }
        return S.pop();
    }
    public static void main(String[] args){
    	String[] tokens = {"0","3","/"};
    	Solution test = new Solution();
    	System.out.println(test.evalRPN(tokens));
    }
}