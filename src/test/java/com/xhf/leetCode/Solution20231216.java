package com.xhf.leetCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Solution20231216 {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组
     * （子数组最少包含一个元素），返回其最大和。子数组 是数组中的一个连续部分。
     */
    public int maxSubArray(int[] nums) {
        // 贪心算法
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
     * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是
     * nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
     * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i],
     * nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
     */
    public int maxSubarraySumCircular(int[] nums) {
        // 贪心算法
        // 思路是一样的
        int max = nums[0];
        int min = nums[0];
        int sumOfCurrentMin = nums[0];
        int sumOfCurrentMax = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sumOfCurrentMax > 0) {
                sumOfCurrentMax += nums[i];
            } else {
                sumOfCurrentMax = nums[i];
            }
            if(sumOfCurrentMax>max){
                max = sumOfCurrentMax;
            }
            if (sumOfCurrentMin < 0) {
                sumOfCurrentMin += nums[i];
            } else {
                sumOfCurrentMin = nums[i];
            }
            if(sumOfCurrentMin<min){
                min = sumOfCurrentMin;
            }
        }
        max = sum == min ? max : Math.max(max, sum - min);
        return max;
    }

    public static void main(String[] args) {
        Solution20231216 solution20231216 = new Solution20231216();
        int[] nums = new int[]{5, -1, 5};
        int i = solution20231216.maxSubarraySumCircular(nums);
        System.out.println(i);
    }
}
