package com.xhf.leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution20231214 {
    /**
     * 给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti]
     * 表示第 i 个区间开始于 lefti 、结束于 righti（包含两侧取值，闭区间）。区间的
     * 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。再给你
     * 一个整数数组 queries 。第 j 个查询的答案是满足 lefti <= queries[j] <= righti
     * 的 长度最小区间 i 的长度 。如果不存在这样的区间，那么答案是 -1 。以数组形式返回对应查询的所有答案。
     */
    public int[] minInterval(int[][] intervals, int[] queries) {
        // queries的下标列表
        Integer[] qindex = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qindex[i] = i;
        }
        // 按照queries的值，将他的下标排序
        Arrays.sort(qindex, Comparator.comparingInt(i -> queries[i]));
        // 按照intervals的left排序
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        // 优先队列，按照区间的长度排序
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // 返回值
        int[] res = new int[queries.length];
        // 初始化为-1
        Arrays.fill(res, -1);
        int i = 0;
        for (int qi : qindex) {
            while (i < intervals.length && intervals[i][0] <= queries[qi]) {
                // 如果在索引范围内，且值大于等于left ，将区间长度、left、right放入优先队列
                // 此时不要管right，因为right可能小于queries[qi]
                pq.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][0], intervals[i][1]});
                i++;
            }
            // 如果优先队列不为空，且优先队列的right小于queries[qi]，则将优先队列的头部弹出
            while (!pq.isEmpty() && pq.peek()[2] < queries[qi]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                res[qi] = pq.peek()[0];
            }
        }
        return res;
    }

    /**
     * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令
     * commands ：
     * -2 ：向左转 90 度
     * -1 ：向右转 90 度
     * 1 <= x <= 9 ：向前移动 x 个单位长度
     * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
     * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，并继续执行下一个命令。
     * 返回机器人距离原点的 最大欧式距离 的 平方 。（即，如果距离为 5 ，则返回 25 ）
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        Robot robot = new Robot();
        robot.addObstacles(obstacles);
        for (int command : commands) {
            robot.turnAndRun(command);
        }
        return robot.maxDistance;
    }
    class Robot {
        int x;
        int y;
        // 0 1 2 3 代表北东南西
        int direction;
        int maxDistance = 0;
        int[][] distance = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        HashSet<Integer> obstacles = new HashSet<>();

        public Robot(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public Robot() {
            this.x = 0;
            this.y = 0;
            this.direction = 0;
        }

        public void turnAndRun(int value) {
            if (-2 == value) {
                this.direction = (this.direction + 3) % 4;
            } else if (-1 == value) {
                this.direction = (this.direction + 1) % 4;
            }else{
                // 向前移动
                for (int i = 0; i < value; i++) {
                    this.x = this.x + distance[this.direction][0];
                    this.y = this.y + distance[this.direction][1];
                    String key = this.x+","+this.y;
                    if( this.obstacles.contains(key.hashCode())) {
                        this.x = this.x - distance[this.direction][0];
                        this.y = this.y - distance[this.direction][1];
                        break;
                    }
                }
                this.maxDistance = Math.max(this.maxDistance, this.x * this.x + this.y * this.y);
            }
        }
        public void addObstacles(int[][] obstacles) {
            if(null == obstacles) {
                return;
            }
            for (int[] obstacle : obstacles) {
                String key = obstacle[0] + "," + obstacle[1];
                this.obstacles.add(key.hashCode());
            }
        }
    }

    public static void main(String[] args) {
        Solution20231214 solution20231214 = new Solution20231214();
        int[] commands = new int[]{6,-1,-1,6};
        int[][] obstacles = new int[][]{};
        int i = solution20231214.robotSim(commands, obstacles);
        System.out.println(i);

    }
}
