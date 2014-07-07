package workbench;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Solution {
    public List<Integer> getRow(int numRows) {
    	numRows++;
    	List<Integer> res = new ArrayList<Integer>();
    	List<Integer>temp = new ArrayList<Integer>();
        for(int i = 0; i < numRows; i++){
    		res.clear();
        	if(i==0){
        		res.add(1);
        	}
        	else{
        		for(int j = 0; j <= i; j++){
        			if(j==0)
        				res.add(1);
            		else if(j==i)
            			res.add(1);
            		else 
            			res.add(temp.get(j-1)+temp.get(j));
        		}        		
        	}
    		temp = new ArrayList<Integer>(res);
        }
        return res;
    }
    public static void main(String[] args){
    	List<Integer> r = new ArrayList<Integer>();
    	Solution test = new Solution();
    	r = test.getRow(3);
    	System.out.println(r);
    	
    }
}
