package com.interview.lucid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NonDecreasing {

    public static final int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

    /**
     * Take a rectangular grid of numbers and find the length
     * of the longest sub-sequence.
     * @return the length as an integer.
     */
    public static int longestSequence(int[][] grid) {
        //invalid input
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int max = 1;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                boolean[][] visited = new boolean[m][n];
                int length = LongestSequenceDFS(grid,m,n,i,j,visited);

                max = Math.max(max, length);
            }
        }

        return max;
    }

    public static int LongestSequenceDFS(int[][] grid, int m, int n, int i, int j, boolean[][] visited){
        if(visited[i][j])
            return 0;
        visited[i][j] = true;
        int maxLength = 1;
        for(int[] direction: directions){
            int x = i + direction[0];
            int y = j + direction[1];
            if(x<0 || x>=m || y<0 || y>=n || visited[x][y] || Math.abs(grid[x][y]-grid[i][j]) <= 3 )
                continue;
            int length = 1 + LongestSequenceDFS(grid,m,n,x,y,visited);
            visited[x][y] = false;
            maxLength = Math.max(length, maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numRows = 0;
        int numCols = 0;
        String[] firstLine = reader.readLine().split("\\s+");
        numRows = Integer.parseInt(firstLine[0]);
        numCols = Integer.parseInt(firstLine[1]);

        int[][] grid = new int[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            String[] inputRow = reader.readLine().split("\\s+");

            for (int col = 0; col < numCols; col++) {
                grid[row][col] = Integer.parseInt(inputRow[col]);
            }
        }
        int length = longestSequence(grid);
        System.out.println(length);
    }
}