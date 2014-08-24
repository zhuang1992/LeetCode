//只需要考虑10进制！那个2e10的sample真是坑人
//交了接近20次才过。。。
package workbench;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
	boolean isInt(String t){
		if(t.length()==0)
			return false;
		int start = (t.charAt(0)=='+' || t.charAt(0)=='-') ? 1:0;
		if(t.equals("0"))
			return true;
		if(start>=t.length())
			return false;
	    for(int i = start; i < t.length(); i++){
	    	if(!(t.charAt(i)>='0' && t.charAt(i)<='9'))
				return false;
	   	}
	    return true;
	}
	boolean isDecimals(String t){
		if(!t.contains("."))
			return false;
		if(t.lastIndexOf(".")!=t.indexOf("."))
			return false;
		String[] n = t.split("\\."); /////////////attention here
		if(n.length==0)
			return false;
		if(n[0].length() == 1 && (n[0].charAt(0)=='+' || n[0].charAt(0)=='-')){
			if(n.length==1)
				return false;
		}else if(n[0].length() != 0 && !isInt(n[0]))
			return false;
		if(n.length > 1)
			for(int i = 0; i < n[1].length(); i++){
	        	if(!(n[1].charAt(i)>='0' && n[1].charAt(i)<='9')){
	        		return false;
	        	}        	
	        }
		return true;
	}
    public boolean isNumber(String s) {
    	s = s.trim();
        if(s.length()<1)
        	return false;        
        String n[] = s.split("e");
        if(n.length == 0)
        	return false;
        if(s.contains("e") && n.length==1)
        	return false;
    	if(s.lastIndexOf("e")!=s.indexOf("e"))
    		return false;
        if(n.length>1){
        	if(!isInt(n[1]))
        		return false;
        }
        return isDecimals(n[0]) || isInt(n[0]);
    }
    public static void main(String[] args){
    	String a = " ";
    	System.out.print(a.trim().length());
    	System.out.print(a.split("e").length);
    	Solution test = new Solution();
    	String t = "1 .";    	
    	System.out.print(test.isNumber(t));
    }
}