//一直stackoverflow，我觉得写得挺好的啊。。服！网上给出的DFS代码也无一例外会stackoverflow。应该是数据被加强了
//难道换成手写栈就OK？还没试。

//网上流传的答案是从外围的'O'开始向里搜，能遇到的'O'都保留，其余的'O'换成'X'。要用BFS，DFS一样会//溢出
package workbench;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	int dir[][]={{1,0},{0,-1},{-1,0},{0,1}};
	int visited[][];
	boolean check(int di, int dj, char[][] board){
		if(visited[di][dj]==2)
			return true;
		if(visited[di][dj]==3)
			return false;
		if(visited[di][dj]==1){
			System.out.print("sth wrong");
			return false;
		}
			
		int n=board.length;
        int m=board[0].length;
		if(di<0 || dj<0 || di>=n || dj>= m){
			System.out.println("sth wrong");
			return false;
		}
		visited[di][dj]=1;		//访问过，但尚未确认
		if(board[di][dj]=='X'){
			visited[di][dj]=2; //确认为真
			return true;			
		}
		if(di==0 || dj==0 || di==n-1 || dj==m-1){
			visited[di][dj]=3; //确认为假
			return false;
		}
		for(int i = 0; i < 4; i++){
			int ni = di + dir[i][0];
			int nj = dj + dir[i][1];
			if(visited[ni][nj]==0){
			    if(check(ni,nj,board)==false){
			    	visited[di][dj]=3;
			    	return false;
		    	}
			}else if(visited[ni][nj]==3){
				visited[di][dj]=3;
				return false;				
			}else
				continue;
		}
		visited[di][dj]=2; 
		return true;
	}
    public void solve(char[][] board) {
        int n=board.length;
        if(n==0)
        	return;
        int m=board[0].length;
        if(m==0)
        	return;
        visited = new int[n][m];
    	for(int i = 0; i < n; i++){
        	for(int j = 0; j < m; j++){
        		if(board[i][j]=='O'){
        			if(check(i,j,board)){
            			board[i][j]='X';
            		}
        		}        		
        	}
        }
    }
    public static void main(String[] args){
    	Solution test  = new Solution();
    	char board[][] = {{'O','O','X','X','O'},{'X','O','X','O','X',},{'X','X','O','X','O'}};
    	test.solve(board);
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0;j < board[0].length; j++){
    			System.out.print(board[i][j]);
    		}
    		System.out.print('\n');
    	}
    }
}