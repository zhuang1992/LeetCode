//越写越乱...sigh
//直接copy了。对这种题缺乏耐心
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
	public int trap(int[] A) {
        int sum = 0;
        int max = -1;
        int maxIndex = -1;
        int prev;

        // find the highest bar
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                maxIndex = i;
            }
        }

        // process all bars left to the highest bar
        prev = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (A[i] > prev) {
                sum += (A[i] - prev) * (maxIndex - i);
                prev = A[i];
            }
            sum -= A[i];
        }

        // process all bars right to the highest bar
        prev = 0;
        for (int i = A.length - 1; i > maxIndex; i--) {
            if (A[i] > prev) {
                sum += (A[i] - prev) * (i - maxIndex);
                prev = A[i];
            }
            sum -= A[i];
        }

        return sum;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int A[]={0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.print(test.trap(A));
    }
}