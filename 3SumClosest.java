class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int value = nums[i] + nums[j] + nums[k];
                if (Math.abs(value - target) < Math.abs(result - target)) {
                    result = value;
                }
                if(value == target) return target;
                else if(value < target) j++;
                else k--;
            }
        }
        return result;
    }
}