class Solution {
    public void solve(char[][] board) {
        int row = board.length, column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0, visited, false);
            }
            
            if(board[i][column - 1] == 'O'){
                dfs(board, i, column - 1, visited, false);
            }
        }
        
         for(int i = 0; i < column; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i, visited, false);
            }
            
            if(board[row - 1][i] == 'O'){
                dfs(board, row - 1, i, visited, false);
            }
        }
               
        for(int i = 1; i < row - 1; i++){
            for(int j = 1; j < column - 1; j++) {
                if(board[i][j] == 'O' && !visited[i][j]){
                    dfs(board, i, j, visited, true);
                }
            }
        }
    }
    
    
    public void dfs(char[][] board, int row, int column, boolean[][] visited, boolean flip) {
        if(row < 0 || row > board.length - 1 || column < 0 || column > board[0].length - 1 || visited[row][column] || board[row][column] == 'X') return;
        
        visited[row][column] = true;
        if(flip){
            board[row][column] = 'X';
        }
        
        dfs(board, row + 1, column, visited, flip);
        dfs(board, row - 1, column, visited, flip);
        dfs(board, row, column + 1, visited, flip);
        dfs(board, row, column - 1, visited, flip);
    }
}
