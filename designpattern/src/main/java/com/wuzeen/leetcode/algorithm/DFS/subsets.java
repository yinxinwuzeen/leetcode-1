package com.wuzeen.leetcode.algorithm.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design_pattern
 * @description: 子集
 * **题目描述：**
 *
 * 给定一组**不含重复元素**的整数数组 *nums*，返回该数组所有可能的子集（幂集）。
 *
 * **说明：**解集不能包含重复的子集。
 *
 * **示例:**
 *
 * ```HTML
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * ```
 *
 * @author: 吴泽恩
 * @create: 2020-07-17 22:25
 **/
public class subsets {
    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private static void dfs(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(nums, index + 1, list);
        list.add(nums[index]);
        dfs(nums, index + 1, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));
        System.out.println(subsets(nums).size());
    }
}
