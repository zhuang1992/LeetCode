package workbench;
public class Solution {
	int f[][] = new int[101][101];
    public int dfs(int i, int j, int m, int n){
    	if(i>=m || j >= n){
    		return 0;
    	}
    	if(i == m-1 && j == n-1){
    		return 1;
    	}
        if(f[i][j]>0)return f[i][j];
        
        return f[i][j]=dfs(i+1, j, m, n)+dfs(i,j+1,m,n);    
    	
    }
    /*int getOrUpdate(int i, int j){
    	
    	return dfs(i,j,visited,m,n);
    }*/
	public int uniquePaths(int m, int n) {
        //System.out.println(visited[1][1]);
        dfs(0,0,m,n);
        return dfs(0,0,m,n);
    }
	public static void main(String[] args){
		Solution test = new Solution();
		System.out.println(test.uniquePaths(3, 1));
		
	}
}