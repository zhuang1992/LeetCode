package workbench;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<Integer> generate(List<Integer>li, int cnt,int dif, int total){
		List<Integer>append = new ArrayList();
		for(int i = li.size()-1; i >= 0; i--){
			append.add(li.get(i)+dif);
		}
		li.addAll(li.size(),append);
		if(cnt==total){
			return li; 
		}
		return generate(li,cnt+1,dif*2,total);
	}
    public List<Integer> grayCode(int n) {
        int arraySize = (int)Math.pow(2, n);
    	List<Integer> ans = new ArrayList<Integer>(arraySize);
       
    	ans.add(0);
    	 if(n==0)
    		 return ans;
        generate(ans,1,1,n);
        /*	int v = 2;
        	int last1 = 0;
        	int last2 = 1;
           for(int i = 1; i < cnt; i++){
        	if(i%2==1){ 		
        		ans.add(i*2,last2+v);
        		ans.add(i*2+1,last1+v);       
        		int temp = last2;
        		last2 = last1+v;        		
        		last1 = temp+v;
        		v*=2;
        	}else{
        		ans.add(i*2,last2+v);
        		ans.add(i*2+1,last1+v);
        		int temp = last2;
        		last2 = last1 + v;
        		last1 = temp + v;
        		v*=2;
        	}        		
        }*/
        return ans;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.println(test.grayCode(0));
    }
}