package workbench;
public class Solution {
	int move[][]={{-1,0},{0,1},{1,0},{0,-1}};
	void dfs(int dir,int cnt, int[][]mat, boolean visited[][],int i,int j, int n){
		while(i < n && j < n && i>=0 && j>=0 && visited[i][j]==false ){
			visited[i][j]=true;
			mat[i][j] = cnt++;
			i+=move[dir][0];
			j+=move[dir][1];
		}
		i-=move[dir][0];
		j-=move[dir][1];
		dir=(dir+1)%4;
		i+=move[dir][0];
		j+=move[dir][1];
		if(visited[i][j]==true)
			return;
		dfs(dir,cnt,mat,visited,i,j,n);
	}
    public int[][] generateMatrix(int n) {
    	
        int mat[][] = new int[n][n];
        if(n==0){
        	return mat;
        }
    	if(n==1){
    		mat[0][0]=1;
    		return mat;
    	}
    	boolean visited[][] = new boolean[n][n];
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		visited[i][j] = false;
        	}
        }
        dfs(1,1,mat,visited,0,0,n);
        return mat;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	
    	int n = 1;
    	int ans[][] = test.generateMatrix(n);
    	for(int i = 0; i < 0; i++){
    		for(int j = 0; j< 0; j++){
    			System.out.print(ans[i][j]+" ");
    		}
    		System.out.println('\n');
    	}
    }
}