class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || numRows >= s.length()) return s;
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) builders[i] = new StringBuilder();
        int n = s.length(), row = 0, step = 1;
        for (int i = 0; i < n; i++) {
            builders[row].append(s.charAt(i));
            if (row == 0) step = 1;
            if (row == numRows - 1) step = -1;
            row += step;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : builders) result.append(sb);
        return result.toString();
    }
}
