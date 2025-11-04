class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        if (n <= 1)
            return 0;
        int result = 0;
        List<Integer> list = new ArrayList<>();
        int size = 0;
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i)) {
                list.add(neededTime[i - 1]);
                size++;
            } else {
                if (size > 0) {
                    list.add(neededTime[i - 1]);
                    list.sort((a, b) -> a.compareTo(b));
                    for(int j = 0; j < size; j++) result += list.get(j);
                    list = new ArrayList<>();
                    size = 0;
                }
            }
        }
        if (size > 0) {
            list.add(neededTime[n - 1]);
            list.sort((a, b) -> a.compareTo(b));
            for(int j = 0; j < size; j++) result += list.get(j);
        }
        return result;
    }
}