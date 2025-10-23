class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0,start = 0, n = s.length();
        for(int end = 0; end < n; end++) {
            while(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}