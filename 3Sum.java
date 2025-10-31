class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        Arrays.sort(nums);
        int j = 0, k = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            j = i + 1; k = nums.length - 1;
            while(j < k) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    list.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    j++;
                }
                else if(nums[i] + nums[j] + nums[k] > 0) k--;
                else j++;
            }
        }
        return new ArrayList<>(list);
    }
}

