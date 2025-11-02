class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return letterCombine(map, result, digits, digits.length(), 0, new StringBuilder());
    }

    public static List<String> letterCombine(Map<Character, String> map, List<String> result, String digits, int n, int index,
            StringBuilder value) {
        if (index == n) {
            result.add(value.toString());
            return result;
        }
        String letters = map.get(digits.charAt(index));
        for (int j = 0; j < letters.length(); j++) {
            value.append(letters.charAt(j));
            letterCombine(map, result, digits,n, index + 1, value);
            value.deleteCharAt(value.length() - 1);
        }
        return result;
    }
}