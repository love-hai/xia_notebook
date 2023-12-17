package com.xhf.leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution20231217 {
    /**
     *leetCode 746. 使用最小花费爬楼梯
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

    /**
     * leetCode 1499. 满足不等式的最大值
     * 给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的
     * 点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] = [xi, yi] ，
     * 并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。
     * 请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k
     * 且 1 <= i < j <= points.length。 题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点。
     */
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = 1;
        while (left<points.length-1) {
            if (points[right][0] - points[left][0] > k) {
                left++;
                right = left + 1;
            } else {
                res = Math.max(res, points[right][1] + points[left][1] + points[right][0] - points[left][0]);
                right++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution20231217 solution20231217 = new Solution20231217();
        int[][] points ={{-17,-6},{-4,0},{-2,-16},{-1,2},{0,11},{6,18}};
        int k = 13;
        System.out.println(solution20231217.findMaxValueOfEquation(points, k));
    }

}
