class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < result.length; i++) {
            result[i] = Xsum(nums, i , i + k, x);
        }
        return result;
    }
    public static int Xsum(int[] nums, int start, int end, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = start ; i < end; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int temp[] = new int[x];
        int max = nums[start];
        for(int i = 0; i < x; i++) {
            for(var set : map.entrySet()) {
                if(map.getOrDefault(max, 0) < set.getValue()) {
                    max = set.getKey();
                }
                else if(map.getOrDefault(max, 0) == set.getValue()) {
                    max = max < set.getKey() ? set.getKey() : max;
                }
            }
            temp[i] = map.getOrDefault(max, 0) * max;
            map.remove(max);
        }
        int sum = 0;
        for(int i = 0; i < x; i++) {
            sum += temp[i];
        }
        return sum;
    }
}