package com.wuzeen.leetcode.datastructure.LinkedList;

/**
 * @program: design_pattern
 * @description: 两数相加
 * **题目描述：**
 *
 * 给出两个 **非空** 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 **逆序** 的方式存储的，并且它们的每个节点只能存储 **一位** 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * **示例：**
 *
 * ```
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * ```
 *
 * @author: 吴泽恩
 * @create: 2020-07-12 15:14
 **/
public class addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode dummy = new ListNode(0);
            ListNode pre = dummy;
            while (l1 != null || l2 != null || carry == 1) {
                pre.next = new ListNode(carry);
                pre = pre.next;
                if (l1 != null) {
                    pre.val += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    pre.val += l2.val;
                    l2 = l2.next;
                }
                carry = pre.val / 10;
                pre.val %= 10;
            }
            return dummy.next;
        }

    public static void main(String[] args) {
        ListNode L1 = new ListNode(3);
        ListNode L2 = new ListNode(3);
        System.out.println(addTwoNumbers(L1,L2).val);
    }
}
