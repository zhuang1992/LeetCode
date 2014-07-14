//一圈一圈地转
//每一圈只是边长不一样，转的规则相同
package workbench;

public class Solution {
	void work(int[][]matrix, int offside){
		int edgelen = matrix.length-offside*2;
		for(int i  = 0; i < edgelen-1; i++){
			int temp = matrix[offside][offside+i];
			matrix[offside][offside+i] = matrix[offside + edgelen - 1- i][offside];
			matrix[offside + edgelen-1-i][offside] = matrix[offside + edgelen-1][offside + edgelen-1-i];
			matrix[offside + edgelen-1][offside + edgelen-1-i] = matrix[offside + i][offside + edgelen-1];
			matrix[offside+i][offside + edgelen-1] = temp;
		}
	}
    public void rotate(int[][] matrix) {
    	int num = matrix.length/2;
    	
    	for(int i = 0; i < num; i++){
    		work(matrix,i);
    	}
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int[][] mat = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
    	for(int i = 0; i < mat.length; i++){
    		for(int j = 0; j < mat.length; j++){
    			System.out.print(mat[i][j]+" ");
    		}
    		System.out.println("");
    	}
    	test.rotate(mat);
    	for(int i = 0; i < mat.length; i++){
    		for(int j = 0; j < mat.length; j++){
    			System.out.print(mat[i][j]+" ");
    		}
    		System.out.println("");
    	}
    }
}