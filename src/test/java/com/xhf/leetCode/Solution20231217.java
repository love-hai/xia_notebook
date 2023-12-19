package com.xhf.leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution20231217 {
    /**
     * leetCode 746. 使用最小花费爬楼梯
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支
     * 付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。你可以选择从
     * 下标为 0 或下标为 1 的台阶开始爬楼梯。请你计算并返回达到楼梯顶部的最低花费。
     */
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

}
