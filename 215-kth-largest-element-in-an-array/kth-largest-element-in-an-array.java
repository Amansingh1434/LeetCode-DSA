class Solution {
    public int findKthLargest(int[] nums, int k) {
        // int n= nums.lenght;
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}