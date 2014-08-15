//有点DP的思想，bottom-up一直求到需要的答案。
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public int numTrees(int n) {
        if(n==1)
            return 1;
        int record[] = new int[n+1];
        record[0] = 1;
        record[1] = 1;
        for(int i = 2; i <= n; i++){
        	int split = i-1;
        	int t = 0;
        	record[i] = 1;
        	while(split>=0){
        		t += record[i-1-split] * record[split];
        		split--;
        	}    
        	record[i] = t;
        }
        return record[n];
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.print(test.numTrees(4));
    }
}