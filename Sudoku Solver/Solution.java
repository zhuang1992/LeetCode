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
            				if(isOver(board)) //����Ѿ������ˣ�����ֱ�ӷ��أ���������ݹ�֮��û�����꣬˵���������ʧ�ܣ�ȥ������һ��k��
            					return ;
            			}
            		    board[i][j]='.';
            		}
        			return ;//����һ����֦����������û�����ֿ��ã�����ֱ�ӷ��أ�����Ҫ�ٿ�����Ŀ��ˡ�
        		}
        	}
        }
        return;
    }
}

