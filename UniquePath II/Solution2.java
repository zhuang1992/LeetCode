public class Solution {
	int f[][] = new int[101][101];
    public int dfs(int m, int n, int[][] obstacleGrid){    	
    	if(m<0 || n < 0){
    		return 0;
    	}
    	if(obstacleGrid[m][n]==1){
    		return 0;
    	}
    	if(m == 0 && n == 0){
    		return 1;
    	}
        if(f[m][n]>0)return f[m][n];
        
        f[m][n]+=dfs(m-1, n, obstacleGrid)+dfs(m,n-1, obstacleGrid); 
        return f[m][n];    	
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	return dfs(m-1,n-1,obstacleGrid);
    }
}