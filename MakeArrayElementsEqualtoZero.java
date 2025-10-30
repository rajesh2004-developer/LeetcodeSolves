class Solution {
    public int countValidSelections(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1 && nums[0] == 0) return 2;
        int result = 0;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int sum = 0;
        for(int i = 0;i < nums.length; i++) {
            sum += nums[i];
            left[i] = sum;
        }
        sum = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            right[i] = sum;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(left[i] == right[i]) {
                    result += 2;
                }
                if(left[i] == right[i] - 1 || left[i] - 1 == right[i]) {
                    result++;
                }
            }
        }
        return result;
    }
}