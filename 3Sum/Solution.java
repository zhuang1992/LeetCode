//通过left和right指针，将复杂度从O(n^3)直接搜，降到O(n^2)
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
    	if(num==null || num.length<3)
    		return rst;
        Arrays.sort(num);
        for(int i = 0; i < num.length-2; i++){
        	if(i!=0 && num[i]==num[i-1])
        		continue;
        	int left = i+1;
        	int right = num.length-1;
        	while(left < right){
        		int sum = num[left]+num[right]+num[i];        		
        		if(sum==0){
        			List<Integer>  sinAns = new ArrayList<Integer>();
        			sinAns.add(num[i]);
        			sinAns.add(num[left]);
        			sinAns.add(num[right]);
        			rst.add(sinAns);
        			left++;right--;
        			while(left<right && num[left]==num[left-1])  //skip duplicates
        				left++;
        			while(left<right && num[right] == num[right+1])
        				right--;
        		}else if(sum < 0){ 	//固定好i，然后根据sum的大小移动left和right，比挨个尝试left和right要好得多(O(n^2) -> O(n))。这种方法很常用。
        			left++;
        		}else{
        			right--;
        		}
        	}
        }
        return rst;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	//int[] S = {-1, 0, 1, 2, -1, -4};
    	int[] S = {-2,-1,0,1,2,3};
    	List<List<Integer>> r = test.threeSum(S);
    	for(int i = 0; i < r.size(); i++){
    		for(int j = 0; j < r.get(i).size(); j++){
    			System.out.print(r.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}
    }
}