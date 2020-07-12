package com.wuzeen.leetcode.datastructure.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: design_pattern
 * @description: 两数之和
 * **题目描述：**
 *
 * 给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * **示例:**
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author: 吴泽恩
 * @create: 2020-07-12 14:49
 **/
public class twoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15,17};
        int target =17;
        System.out.println(twoSum(nums,target)[0]+":"+nums[twoSum(nums,target)[0]]);
        System.out.println(twoSum(nums,target)[1]+":"+nums[twoSum(nums,target)[1]]);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
