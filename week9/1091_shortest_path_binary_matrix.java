class Solution {
    private int[] X = {0,1,1,1,0,-1,-1,-1};//方向数组
    private int[] Y = {1,1,0,-1,-1,-1,0,1};
    private int m,n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        m = grid.length; n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;//特殊情况特殊考虑，出口和入口被堵死
        boolean[][] v = new boolean[m][n];
        Queue<int[]> a = new LinkedList();
        a.add(new int[]{0,0});
        v[0][0] = true;
        int step = 1;
        while (!a.isEmpty()){
            int s =  a.size();
            for (int i = 0; i < s;i++){
                int[] temp = a.poll();
                int x = temp[0];
                int y = temp[1];
                 if(x==m-1 && y==n-1) return step;//终止条件
                for(int j=0;j<8;j++){
                    int x1 = x + X[j];
                    int y1 = y + Y[j];
                    if(x1>=0 && x1<m && y1>=0 && y1<n && grid[x1][y1]==0 && !v[x1][y1]){
                        a.add(new int[]{x1,y1});//入队
                        v[x1][y1] = true;
                    }
                }
               
            }
            step++;
        }
        return -1;//队列为空即为不能到达终点，返回-1
    }
}
