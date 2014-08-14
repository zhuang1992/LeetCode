//��������Ƚϼ򵥴ֱ������Ǻ����
package workbench;

import java.util.Stack;

public class Solution {
	boolean biSearch(int[] A, int low, int high, int target){
		if(low>high)
			return false;
		int mid = (high+low)>>1;
		if(A[mid]==target){
			return true;
		}else	if(A[low] < A[high]){
			return A[mid]>target?biSearch(A,low,mid-1,target):biSearch(A,mid+1,high,target);//�������������������(û��rotate)��ֱ����ͨ���ֲ���
		}else{
			return biSearch(A,low,mid-1,target) || biSearch(A,mid+1,high,target); //�ؼ��ڴˡ����������rotated����ī�����ɴ����߶��ѡ�ʱ�临�Ӷ�������
		}
	}
    public boolean search(int[] A, int target) {
        return biSearch(A,0,A.length-1,target);
    }
    public static void main(String[] args){
    	int A[] = {1,3,1,1,1};
    	Solution test = new Solution();
    	System.out.println(test.search(A, 3));
    }
}