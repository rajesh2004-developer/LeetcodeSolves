class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    long value = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (value == target) {
                        result.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[l])));
                        k++;
                        l--;
                        while(k < l && nums[k - 1] == nums[k]) k++;
                        while(k < l && nums[l + 1] == nums[l]) l--;
                    } else if (value < target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return result;
    }
}