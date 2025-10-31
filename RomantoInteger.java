class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>() {
            {
                put("I", 1);
                put("IV", 4);
                put("V", 5);
                put("IX", 9);
                put("X", 10);
                put("XL", 40);
                put("L", 50);
                put("XC", 90);
                put("C", 100);
                put("CD", 400);
                put("D", 500);
                put("CM", 900);
                put("M", 1000);
            }
        };
        int n = s.length();
        String value = "";
        for(int i = n - 1; i >= 0; i--) {
            if(value.isEmpty()) value = s.charAt(i) + "";
            else if(map.containsKey(s.charAt(i) + value)) {
                result += map.get(s.charAt(i) + value);
                value = "";
            }
            else {
                result += map.get(value);
                value = s.charAt(i) + "";
            }
        }

        if(value.length() != 0) result += map.get(value);

        return result;
    }
}