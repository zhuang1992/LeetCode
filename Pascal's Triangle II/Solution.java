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

//Tried Again
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>cur = new LinkedList<Integer>();
        for(int i = 0; i < 3; i++){
        	cur.add(0);
        }
        cur.set(1, 1);
        List<Integer> nextLv = new LinkedList<Integer>();
        nextLv.add(0);
    	for(int i = 0; i < rowIndex; i++){
        	for(int j = 0; j <= i+1; j++){
        		nextLv.add(cur.get(j)+cur.get(j+1));
        	}
        	nextLv.add(0);
        	cur = nextLv;
        	nextLv = new LinkedList<Integer>();
        	nextLv.add(0);
        }
    	cur.remove(0);
    	cur.remove(cur.size()-1);
    	return cur;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	List<Integer> r = test.getRow(3);
    	for(int i : r)
    		System.out.print(i);
    }
}