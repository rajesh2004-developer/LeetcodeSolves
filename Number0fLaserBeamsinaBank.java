class Solution {
    public int numberOfBeams(String[] bank) {
        int result = 0, prev = 0 , current = 0;
        for(String s : bank) {
            if(prev == 0) {
                for(char c : s.toCharArray()) {
                    prev += c - '0';
                }
            }
            else if(current == 0) {
                for(char c : s.toCharArray()) {
                    current += c - '0';
                }
            }
            if(prev != 0 && current != 0) {
                result += (prev * current);
                prev = current;
                current = 0;
            }
        }
        return result;

    }
}