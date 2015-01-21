//本质上是桶排序，只不过桶的大小是1，即把数i存在下标为i-1处。
//如果数i<0或i>n，则break掉，即随便放在一个空的地方就行。它所在的桶即认为是空。
package workbench;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
public class Solution {
	void bucketSort(int[] A){
		for(int i = 0; i < A.length; i++){
        	while(A[i]!=i+1){
        		if(A[i]<=0 || A[i] >A.length || A[i]==A[A[i]-1])
        			break;
        		int temp = A[i];  //swap(A[i], A[A[i]-1])
        		A[i] = A[A[i]-1];
        		A[temp-1] = temp;  //注意这里
        	}
        }
	}
    public int firstMissingPositive(int[] A) {
        bucketSort(A);
        for(int i = 0; i < A.length; i++){
        	if(A[i]!=i+1) //找到第一个空桶
        		return i+1;
        }
        return A.length+1;
    }
    public static void main(String[] args){
    	int A[]={2,1};
    	Solution test = new Solution();
    	System.out.print(test.firstMissingPositive(A));
    }
}