class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i++) {
            int n = sb.length(), j = 0;
            for(char c: strs[i].toCharArray()) {
                if(j == n) break;
                if(sb.charAt(j) == c) j++;
                else {
                    sb.delete(j, n);
                    break;
                }
            }
            if(j < n) sb.delete(j, n);
        }
        return sb.toString();
    }
}