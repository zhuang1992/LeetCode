//here we try to deal with a more general case: find the kth largest number in 2 sorted arrays
//next time try n sorted arrays
package workbench;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
	double findKth(int A[], int sa, int B[], int sb, int k){
		int la = A.length - sa;
		int lb = B.length - sb;
		if(la < 0 || lb < 0)
			return 0;
		if(la > lb)
			return findKth(B, sb, A, sa, k);
		if(la == 0)
			return B[sb+k-1];
		if(k==1)
			return Math.min(A[sa], B[sb]);
		//divide k into two parts
		int pa = Math.min(k / 2, la), pb = k - pa; 
		
		if(A[sa+pa-1] < B[sb+pb-1]){
			return findKth(A,sa+pa, B, sb, k-pa);    //从k中drop掉pa个元素。worst case中，pa=1/2*k,1/4*...，k =(m+n)/2，因此复杂度为log(m+n)
		}else if(A[sa+pa-1] > B[sb+pb-1]){
			return findKth(B, sb+pb, A, sa, k-pb);
		}else{
			return A[sa+pa-1];
		}
	}
    public double findMedianSortedArrays(int A[], int B[]) {
    	int total = A.length + B.length;
    	if((total & 0x1) ==0){
    		return (findKth(A, 0, B, 0,  total/2)+findKth(A, 0, B, 0, total/2 + 1)) / 2;
    	}
        return findKth(A, 0, B, 0, total/2+1);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int A[] = {1,};
    	int B[] = {4,5};
    	System.out.print(test.findMedianSortedArrays(A, B));
    }
}