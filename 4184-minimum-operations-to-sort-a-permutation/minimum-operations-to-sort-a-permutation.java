
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int ans = getCost(nums, false);

        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = nums[n - 1 - i];
        }

        ans = Math.min(ans, getCost(reversed, true));

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int getCost(int[] arr, boolean reversed) {
        int n = arr.length;
        int zeroIndex = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroIndex = i;
                break;
            }
        }

        // Check whether a left rotation produces sorted order.
        for (int i = 0; i < n; i++) {
            if (arr[(zeroIndex + i) % n] != i) {
                return Integer.MAX_VALUE;
            }
        }

        int k = zeroIndex;

        if (reversed) {
            return 1 + Math.min(k, n - k);
        }

        if (k == 0) {
            return 0;
        }

        return Math.min(k, n - k + 2);
    }
}
