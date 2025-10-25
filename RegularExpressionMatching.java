class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] arr = new boolean[m + 1][n + 1];
        arr[0][0] = true;
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                arr[0][j] = arr[0][j - 2];
            }
        }
        for(boolean[] ar: arr)
            System.out.println(Arrays.toString(ar));
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(p.charAt(j - 1) == '*') {
                    arr[i][j] = arr[i][j - 2] || arr[i - 1][j] && ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
                else {
                    arr[i][j] = arr[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
            for(boolean[] ar: arr)
            System.out.println(Arrays.toString(ar));
        }
            return arr[m][n];
    }
}