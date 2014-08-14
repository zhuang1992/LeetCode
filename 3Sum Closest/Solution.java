
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
    	if(num==null || num.length<3)
    		return -1;
    	int minDis = 999999999;
    	int res = 0;
        Arrays.sort(num);
        for(int i = 0; i < num.length-2; i++){
        	if(i!=0 && num[i]==num[i-1])
        		continue;
        	int left = i+1;
        	int right = num.length-1;
        	while(left < right){
        		int dis =(num[left]+num[right]+num[i] - target);        	
        		if( Math.abs(dis) < minDis){
        			minDis =  Math.abs(dis);
        			res = num[left]+num[right]+num[i];
        		}
        		if(dis==0){
        			return res;
        		}else if(dis < 0){  
        			left++;
        		}else{
        			right--;
        		}
        	}
        }
        return res;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	//int[] S = {-1, 0, 1, 2, -1, -4};
    	int[] S = {-1, 2, 1, -4};
    	System.out.println(test.threeSumClosest(S, 0));
    	
    }
}