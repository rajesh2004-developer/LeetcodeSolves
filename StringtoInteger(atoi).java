class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0)
            return 0;
        char sign = '+';
        if (s.charAt(0) == '-') {
            sign = '-';
            s = s.substring(1);
        } else if (s.charAt(0) == '+')
            s = s.substring(1);
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (((double) result * 10 + (c - '0')) > Integer.MAX_VALUE) {
                    return sign == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + (c - '0');
            } else
                break;
        }
        return sign == '+' ? result : -result;
    }
}