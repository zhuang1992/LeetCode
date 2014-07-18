//直接减，会超时，如2147483647，1这种数据
//二分啊，简直机智。注意边界情况。
//注意各种正负问题的预处理
//注意被除数比除数小时，直接返回0
package workbench;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Solution {
    public int divide(int dividend, int divisor) {
    	long d1 = (long) dividend;
    	long d2 = (long) divisor;
     	int symbol = 1;
    	if(d2 >0 && d1 <0){
    		d1 = -d1;
    		symbol = -1;
    	}else if(d2 <0 && d1 >0){
    		d2 = -d2;
    		symbol = -1;
    	}else{
    		d2 = Math.abs(d2);
    		d1 = Math.abs(d1);
    	}
    	if(d2==1)
    		return (int)d1*symbol;
    	if(d1<d2)
    		return 0;
    	
    	long low = 1;
    	long high = d1;
    	long mid=0;
    	while(low<=high){
    		mid = (low+high)>>1;
    		if(mid * d2 > d1){
    			high = mid - 1;
    		}else if(mid * d2 < d1){
    			low = mid + 1;
    			if((mid+1)*d2>d1)
    				break;
    		}else{
    			break;
    		}
    			
    	}
    	return (int)mid*symbol;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.print(test.divide(2147483647,2));
    }
}