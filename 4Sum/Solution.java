//˼·��3Sumһ����ֻ�������˸�ָ��j
//4��ָ��i,j,left,right��˾��λ��ע�����ȥ�أ�������֮����������Ҫ��
//left��right���ƶ���ʽ��ʹ�ø��Ӷȴ�O(n^4)������O(n^3)
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