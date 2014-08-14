//思路和3Sum一样，只不过多了个指针j
//4个指针i,j,left,right各司其位，注意各自去重，但它们之间如果相等则不要紧
//left和right的移动方式，使得复杂度从O(n^4)降到了O(n^3)
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
    	if(num==null || num.length<4)
    		return rst;
        Arrays.sort(num);
        for(int i = 0; i < num.length-3; i++){
        	if(i!=0 && num[i]==num[i-1])
        		continue;
        	for(int j = i + 1; j < num.length-2; j++){
        		if(j!=i+1 && num[j] == num[j-1])
        			continue;
        		int left = j+1;
            	int right = num.length-1;
            	while(left < right){
            		int sum = num[i]+num[j]+num[left]+num[right];
            		if(sum==target){
            			List<Integer>temp = new ArrayList<Integer>();
            			temp.add(num[i]);
            			temp.add(num[j]);
            			temp.add(num[left]);
            			temp.add(num[right]);
            			rst.add(temp);
            			left++;right--;
            			while(left < right && num[left] == num[left-1])
            				left++;
            			while(left < right && num[right] == num[right+1])
            				right--;
            		}else if(sum < target){
            			left++;
            		}else{
            			right--;
            		}
            	}
        	}        	
        }
        return rst;
    }
}