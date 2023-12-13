package com.xhf.leetCode;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @projectName: test
 * @package: com.xhf.leetCode
 * @className: Solution20231213
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/12/13 13:37
 * @updateUser: xiahaifeng
 * @updateDate: 2023/12/13 13:37
 * @updateRemark:
 */

@Slf4j
public class Solution20231213 {
    /**
     * 给你一个由 小写英文字母 组成的字符串 s ，你可以对其执行一些操作。在一步操作中，你可以用其他小写英文字母 替换  s 中的一个字符。
     * 请你执行 尽可能少的操作 ，使 s 变成一个 回文串 。如果执行 最少 操作次数的方案不止一种，则只需选取 字典序最小 的方案。
     * 对于两个长度相同的字符串 a 和 b ，在 a 和 b 出现不同的第一个位置，如果该位置上 a 中对应字母比 b 中对应字母在字母表中
     * 出现顺序更早，则认为 a 的字典序比 b 的字典序要小。 返回最终的回文字符串。
     */
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int mid = chars.length / 2;
        for (int i = 0; i < mid; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                chars[i] = chars[chars.length - i - 1] = (char) Math.min(chars[i], chars[chars.length - i - 1]);
            }
        }
        return new String(chars);
    }

    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
     * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符
     * 串转换为整数形式。
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            // 数字0-9的ASCII码值为48-57，减去48就是对应的数字。
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            ans.append((x + y + add) % 10);
            add = (x + y + add) / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    /**
     * 给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti]
     * 表示第 i 个区间开始于 lefti 、结束于 righti（包含两侧取值，闭区间）。区间的
     * 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。再给你
     * 一个整数数组 queries 。第 j 个查询的答案是满足 lefti <= queries[j] <= righti
     * 的 长度最小区间 i 的长度 。如果不存在这样的区间，那么答案是 -1 。以数组形式返回对应查询的所有答案。
     */
    public int[] minInterval(int[][] intervals, int[] queries) {
        // 先将intervals按照left排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 将queries按照从小到大排序,并且记录下标
        Map<Integer, List<Integer>> mapValue_I = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            if(!mapValue_I.containsKey(queries[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                mapValue_I.put(queries[i], list);
            }else {
                mapValue_I.get(queries[i]).add(i);
            }
        }
        int[] result = new int[queries.length];
        // 将queries按照从小到大排序,并且去重
        queries = Arrays.stream(queries).distinct().toArray();
        Arrays.sort(queries);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(i, null);
        }
        for (int query : queries) {
            int dis = -1;
            for (int j = 0; j < intervals.length; j++) {
                if (dis == 1) {
                    break;
                }
                if (query >= intervals[j][0] && query <= intervals[j][1]) {
                    map.computeIfAbsent(j, j1 -> intervals[j1][1] - intervals[j1][0] + 1);
                    if (dis == -1) {
                        dis = map.get(j);
                    } else {
                        dis = Math.min(dis, map.get(j));
                    }
                } else if (query < intervals[j][0]) {
                    break;
                }
            }
            int finalDis = dis;
            mapValue_I.get(query).forEach(integer -> result[integer] = finalDis);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = {{4,5},{5,8},{1,9},{8,10},{1,6}};
        int[] b = {7,9,3,9,3};
        Solution20231213 solution20231213 = new Solution20231213();
        log.info(Arrays.toString(solution20231213.minInterval(a, b)));
    }
}
