package com.Algorithm;

public class qianzuihe {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] ans = productExceptSelf(nums);
        System.out.println(ans);
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 1, j = 1; i <= n; i++) {
            ans[i - 1] = j;
            j *= nums[i - 1];
        }
        for (int i = n, j = 1; i >= 1; i--) {
            ans[i - 1] *= j;
            j *= nums[i - 1];
        }
        return ans;
    }
}
