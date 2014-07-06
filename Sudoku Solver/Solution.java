package workbench;
public class Solution{
	boolean isValid(char[][]board, int x, int y){
		for(int i = 0; i<board.length; i++){
			if(i==x)continue;
			if(board[i][y]==board[x][y])
				return false;
		}
		for(int j = 0; j < board[0].length; j++){
			if(j==y)continue;
			if(board[x][j]==board[x][y])
				return false;
		}
		
		int nx = x/3;
		int ny = y/3;
		for(int i = 3*nx; i < 3*nx+3; i++){
			for(int j = 3*ny; j < 3*ny+3; j++){
				if(i==x && j==y)
					continue;
				if(board[i][j]==board[x][y])
					return false;
			}
		}
		return true;
	}
	boolean isOver(char[][]board){
		boolean over=true;
		for(int i = 0; i < board.length; i++){
        	for(int j = 0; j < board[0].length; j++){
        			if(board[i][j]=='.')
        				over=false;
        	}
        }
		return over;
	}
	public void solveSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
        	for(int j = 0; j < board[0].length; j++){
        		if(board[i][j]=='.'){
        			for(int k = 1; k <=9; k++){
            			board[i][j] = (char) (k+'0');
            			if(isValid(board,i,j)){
            				solveSudoku(board);
            				if(isOver(board)) //如果已经填完了，可以直接返回；如果经过递归之后没有填完，说明这个尝试失败，去尝试下一个k。
            					return ;
            			}
            		    board[i][j]='.';
            		}
        			return ;//这是一个剪枝，如果这个空没有数字可用，可以直接返回，不需要再看后面的空了。
        		}
        	}
        }
        return;
    }
}

