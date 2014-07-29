//手写栈该怎么写。。？
package workbench;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
	class Position{
		int i;
		int j;
		Position(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	int dir[][]={{1,0},{0,-1},{-1,0},{0,1}};
	int visited[][];
	
	boolean check2(int di, int dj, char[][]board){		
		Position cur = new Position(di,dj);
		Stack<Position>S = new Stack<Position>();
		S.push(cur);
		while(!S.isEmpty()){
			Position f = S.pop();
			int fi = f.i;
			int fj = f.j;
			if(visited[fi][fj]==2){
				continue;
			}
			if(visited[fi][fj]==3){
				while(!S.isEmpty()){
					Position t = S.pop();
					visited[t.i][t.j] = 3;
				}
				return false;				
			}

			int n=board.length;
	        int m=board[0].length;

			if(board[fi][fj]=='X'){
				visited[fi][fj]=2; //确认为真
				continue;		
			}
			if(fi==0 || fj==0 || fi==n-1 || fj==m-1){
				visited[fi][fj]=3; 
				while(!S.isEmpty()){
					Position t = S.pop();
					visited[t.i][t.j] = 3;
				}
				return false;
			}
			for(int i = 0; i < 4; i++){
				int ni = fi + dir[i][0];
				int nj = fj + dir[i][1];
				if(visited[ni][nj]==0){
					visited[ni][nj]=1;	
					S.push(new Position(ni,nj));
				}
			}
		}
		visited[di][dj]=2; 
		return true;		
	}
	
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
		if(board[di][dj]=='X'){
			visited[di][dj]=2; //确认为真
			return true;			
		}
		if(di==0 || dj==0 || di==n-1 || dj==m-1){
			visited[di][dj]=3; //确认为假
			return false;
		}
		visited[di][dj]=1;		//访问过，但尚未确认
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
        			if(check2(i,j,board)){
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