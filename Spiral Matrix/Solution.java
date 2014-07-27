//没用DFS，直接模拟。
//编码能力还是太弱啊
package workbench;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	List<Integer> res = new LinkedList<Integer>();
    void getCircle(int si, int sj, int matrix[][]){
    	int msteps = matrix.length-si*2-1;
		int nsteps = matrix[0].length-sj*2-1;
		if(msteps<0 || nsteps<0)
			return ;
		if(msteps==0 && nsteps==0){
			res.add(matrix[si][sj]);
			return;
		}		
		if(msteps == 0){
			for(int j  = 0; j <= nsteps; j++){
				res.add(matrix[si][sj+j]);
			}
			return;
		}
		if(nsteps == 0){
			for(int i  = 0; i <= msteps; i++){
				res.add(matrix[si+i][sj]);
			}
			return;
		}
		for(int j  = 0; j < nsteps; j++){
			res.add(matrix[si][sj+j]);
		}
		for(int i  = 0; i < msteps; i++){
			res.add(matrix[si+i][sj+nsteps]);
		}
		for(int j  = nsteps; j >= 1; j--){
			res.add(matrix[si+msteps][sj+j]);
		}
		for(int i  = msteps; i >= 1; i--){
			res.add(matrix[si+i][sj]);
		}
		return;
    }
	public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		if(m==0)
			return res;
		int n = matrix[0].length;
		if(n==0)
			return res;
		int si = 0;
		int sj = 0;
		while(si < m || sj < n){
			getCircle(si,sj,matrix);
			si++;sj++;
		}
		return res;
	}
	public static void main(String[] args){
		Solution test  = new Solution();
		int m[][] = {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer>res = test.spiralOrder(m);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}		
	}
}