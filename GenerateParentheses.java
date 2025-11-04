class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, result, 0, 0, new StringBuilder());
        return result;
    }
    public static void helper(int n, List<String> result, int open, int close, StringBuilder value) {
        if (open + close == n * 2) {
            result.add(value.toString());
        }
        if (open < n) {
            value.append('(');
            helper(n, result, open + 1, close, value);
            value.deleteCharAt(value.length() - 1);
        }
        if (close < open) {
            value.append(')');
            helper(n, result, open, close + 1, value);
            value.deleteCharAt(value.length() - 1);
        }
    }
}