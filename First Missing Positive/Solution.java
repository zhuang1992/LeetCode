//��������Ͱ����ֻ����Ͱ�Ĵ�С��1��������i�����±�Ϊi-1����
//�����i<0��i>n����break������������һ���յĵط����С������ڵ�Ͱ����Ϊ�ǿա�
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
        		A[temp-1] = temp;  //ע������
        	}
        }
	}
    public int firstMissingPositive(int[] A) {
        bucketSort(A);
        for(int i = 0; i < A.length; i++){
        	if(A[i]!=i+1) //�ҵ���һ����Ͱ
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