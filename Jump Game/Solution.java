//���ƣ�ֻ��Ҫ�ҵ�һ�����н⣬����true����
package workbench;
public class Solution {
	boolean dfs(int [] T, int len){
		if(len == 1)
			return true;
		for(int i = len - 2; i >= 0; i--){
        	if(T[i] >= len-1-i){
        		return dfs(T, i+1);  //����ط�����ֱ��return���е���˼��
        									//������ô�룬��������T[i]�������ˣ��Ϳ϶����������һ���ˣ�ֱ�ӷ���false���У������ٳ��Ը���ǰ(��С��i)�ˡ�
        	}
        }
		return false;
	}
    public boolean canJump(int[] A) {
        return dfs(A, A.length);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int A[] = {2,1,0,1,4};
    	System.out.println(test.canJump(A));
    }
}