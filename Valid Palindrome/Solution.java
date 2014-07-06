package workbench;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
public class Solution {
    
    public boolean isPalindrome(String s) {
    	int len = s.length();
    	if(s.length()==0)
    		return true;
    	int i = 0;
    	int j = len - 1;
    	while(i<j){
    		while(!((s.charAt(i)>='a' && s.charAt(i) <='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='0' && s.charAt(i)<='9'))){
        		i++;
        		if(i>j)
        			return true;
        	}
    		while(!((s.charAt(j)>='a' && s.charAt(j) <='z') || (s.charAt(j)>='A' && s.charAt(j)<='Z')|| (s.charAt(j)>='0' && s.charAt(j)<='9'))){
        		j--;
        		if(i>j)
        			return true;;
        	}
        	if(s.charAt(i) == s.charAt(j) || Math.abs(s.charAt(i)-s.charAt(j))=='a'-'A'){
        		i++;
        		j--;
        	}else{
        		return false;
        	}
    	}
        return true;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.println(test.isPalindrome("1a2"));
    }
}
