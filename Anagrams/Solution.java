package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        List<String>rst = new LinkedList<String>();	
    	for(int i = 0; i < strs.length; i++){
        	char[] cb = strs[i].toCharArray();
        	Arrays.sort(cb);
        	String n = String.valueOf(cb);
        	if(hash.containsKey(n)){  
        		if(hash.get(n)>=0){			//�������Ǹ�string��û���Ž�rst��������������Ϊ-1����ʾ�Ź��ˣ��Ժ󲻱��ٷš���㶼û��������������׽����
        			rst.add(strs[hash.get(n)]);
        			hash.put(n, -1);
        		}
        		rst.add(strs[i]);        		
        	}else{
        		hash.put(n, i);
        	}       	
        }
    	return rst;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	String strs[] = {"tea","eat","and","nad"};
    	List<String>r = test.anagrams(strs);
    	for(String t : r)
    		System.out.println(t);
    }
}