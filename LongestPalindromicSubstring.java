class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) return s;
        String maxValue = "";
        int n = s.length(), maxLength = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + maxLength - 1; j < n; j++) {
                String value = s.substring(i, j + 1);
                if(isPalindrome(value)) {
                    maxValue = (maxLength < j - i + 1 ? value : maxValue);
                    maxLength = j - i + 1 > maxLength ? j - i + 1 : maxLength;
                }
            }
        }
        return maxValue;
    }
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}