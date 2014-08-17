//注意几种特殊情况，如长度为0
//其它的就好水了。连KMP都用不到，直接上最朴素的。
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public String strStr(String haystack, String needle) {
    	if(needle.length() == 0)
    		return haystack;    	
    	if(haystack.length() < needle.length())
    		return null;
        for(int i = 0; i < haystack.length(); i++){
        	int ptr = i;
        	for(int j = 0; j < needle.length(); j++){
        		if(haystack.charAt(ptr) != needle.charAt(j))
        			break;
        		else{
        			if(j == needle.length()-1)
        				return haystack.substring(i);
        			ptr++;
        			if(ptr == haystack.length() && j < needle.length())
        				return null;
        		}
        	}
        }
        return null;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.print(test.strStr("aaa","aaa"));
    }
}