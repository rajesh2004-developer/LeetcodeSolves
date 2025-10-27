class Solution {
    public int maxArea(int[] height) {
        int result = 0, start = 0, end = height.length - 1;
        while (start < end) {
            int minHeight = Math.min(height[start], height[end]);
            result = Math.max(result, (end - start) * minHeight);
            while(start < end && height[start] <= minHeight) start++;
            while(start < end && height[end] <= minHeight) end--;
        }
        return result;
    }
}