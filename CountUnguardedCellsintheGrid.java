class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int result = m * n;
        char[][] matrix = new char[m][n];
        for (int i = 0; i < walls.length; i++) {
            result--;
            matrix[walls[i][0]][walls[i][1]] = 'w';
        }
        for (int i = 0; i < guards.length; i++) {
            result--;
            matrix[guards[i][0]][guards[i][1]] = 'g';
        }
        for (int a = 0; a < guards.length; a++) {
            int i = guards[a][0], j = guards[a][1];
            //down
            for (int k = i + 1; k < m; k++) {
                if (matrix[k][j] == 'w' || matrix[k][j] == 'g')
                    break;
                if (matrix[k][j] == '\u0000') {
                    result--;
                    matrix[k][j] = 'G';
                }
            }
            //top
            for (int k = i - 1; k >= 0; k--) {
                if (matrix[k][j] == 'w' || matrix[k][j] == 'g')
                    break;
                if (matrix[k][j] == '\u0000') {
                    result--;
                    matrix[k][j] = 'G';
                }

            }
            //left
            for (int k = j - 1; k >= 0; k--) {
                if (matrix[i][k] == 'w' || matrix[i][k] == 'g')
                    break;
                if (matrix[i][k] == '\u0000') {
                    result--;
                    matrix[i][k] = 'G';
                }
            }
            //right
            for (int k = j + 1; k < n; k++) {
                if (matrix[i][k] == 'w' || matrix[i][k] == 'g') {
                    break;
                }
                if (matrix[i][k] == '\u0000') {
                    result--;
                    matrix[i][k] = 'G';
                }
            }
        }
        return result;
    }
}