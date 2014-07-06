package workbench;
public class Solution {
    int move[][]={{-1,0},{0,1},{1,0},{0,-1}};
    boolean visited[][] ;
	public boolean dfs(char[][]board, int i, int j, String word, int cnt){
		if(cnt==word.length())return true;
    	if(i<0 || i>=board.length || j<0 || j>=board[i].length)
    		return false;
    	if(visited[i][j]==true)
    		return false;
    	if(board[i][j]==word.charAt(cnt)){
    		visited[i][j]=true;
    		for(int k = 0; k < 4; k++){
    			int ti = i+move[k][0];
    			int tj = j+move[k][1];
    			if(dfs(board,ti,tj,word,cnt+1)){
    				return true;
    			}
    		}
    		return false;
    	}
    	return false;
    }
	public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
        	for(int j = 0; j < board[i].length; j++){
        		visited = new boolean[board.length][board[i].length];
        		if(dfs(board, i, j, word, 0))
        			return true;
        	}
        }
        return false;
    }
	public static void main(String[] args){
		Solution test = new Solution();
		char[][]board = {{'a'},{'a'}}; //{{'A','B','C','E'},{'S','F','C','S'},  {'A','D','E','E'}};
		String word = "aaa";
		System.out.println(test.exist(board, word));
	}
}