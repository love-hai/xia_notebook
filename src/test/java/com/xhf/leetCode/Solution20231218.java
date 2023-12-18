package com.xhf.leetCode;

public class Solution20231218 {
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
        // 定义一个双端队列
        Deque deque = new Deque();
        for (int[] point : points) {
            while (deque.head != null && point[0] - deque.head.value[1] > k) {
                deque.popLeft();
            }
            if (deque.head != null) {
                res = Math.max(res, point[1] + point[0] + deque.head.value[0]);
            }
            int[] value = {point[1] - point[0], point[0]};
            while (deque.tail != null && deque.tail.value[0] < value[0]) {
                deque.pop();
            }
            deque.push(value);
        }
        return res;
    }
    class Deque {
        public Node head= null;
        public Node tail = null;
        class Node {
            public int[] value;
            public Node next= null;
            public Node pre = null;
            public Node(int[] value) {
                this.value = value;
            }
        }

        public void push(int[] value) {
            Node node = new Node(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
                node.pre = tail;
            }
            tail = node;
        }

        public int[] pop() {
            if (tail== null) {
                return null;
            }
            int[] value = tail.value;
            tail = tail.pre;
            if(tail!=null){
                tail.next = null;
            }else {
                head = null;
            }
            return value;
        }
        public int[] popLeft() {
            if (head == null) {
                return null;
            }
            int[] value = head.value;
            head = head.next;
            if(head!=null){
                head.pre = null;
            }else {
                tail = null;
            }
            return value;
        }
    }


    /**
     * leetCode 162. 寻找峰值
     * 峰值元素是指其值严格大于左右相邻值的元素。给你一个整数数组 nums，
     * 找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，
     * 返回 任何一个峰值 所在位置即可。你可以假设 nums[-1] = nums[n] = -∞ 。
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     */
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) / 2;
        while (left < right) {
            if (nums[middle] > nums[middle + 1]) {
                right = middle;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution20231218 solution20231218= new Solution20231218();
        int[][] points = {{-17, -6}, {-4, 0}, {-2, -16}, {-1, 2}, {0, 11}, {6, 18}};
        int k = 13;
        System.out.println(solution20231218.findMaxValueOfEquation(points, k));
    }
}
