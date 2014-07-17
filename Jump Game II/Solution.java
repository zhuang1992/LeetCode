//jump game Iֻ���ҵ�һ�����н�ͷ���true����˴��������ұȽϿ�
//��jump game II��Ҫ�ҵ�һ����̵�����������ȴ��������ң��ҵ�������target�������Ǹ���p��Ȼ��ݹ�����������p�����ĵ㡣
//������ҵ�����target��Ϊ0���򷵻����Ĳ�����������ܣ��򷵻���һ�㣬���������ҡ�
package workbench;

import java.util.*;
public class Solution {
	int dfs(int[] A, int target){
		if(target == 0){
			return 0;
		}
		for(int i = 0; i <target; i++){
    		if(A[i] >= target - i){
    			int  t = dfs(A, i);
    			if(t!=-1){
    				return t+1;
    			}
    		}
    	}
		return -1;
	}
    public int jump(int[] A) {
        int len = A.length;
    	return dfs(A, len-1);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int A[] = {2,3,1,1,4};
    	System.out.print(test.jump(A));
    }
}