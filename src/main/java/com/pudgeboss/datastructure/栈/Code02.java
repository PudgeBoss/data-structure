package com.pudgeboss.datastructure.栈;

import java.util.Stack;

/**
 * 判断字符串括号是否合法
 * <p>
 * 方法：
 * 1。模拟：模拟题目的运行。
 * 2。规律：尝试总结出题目的一般规律和特点。
 * 3。匹配：找到符合这些特点的数据结构与算法。
 * 4。边界：考虑特殊情况。
 *
 * @author pudgeboss
 * @email pudgeboss@163.com
 * @date 2021-08-06 00:28
 */
public class Code02 {

    public boolean isValid(String s) {
        // 当字符串本来就是空的时候，我们可以快速返回true
        if (null == s || s.length() == 0) {
            return true;
        }
        // 当字符串长度为奇数的时候，不可能是一个有效的合法字符串
        if (s.length() % 2 == 1) {
            return false;
        }
        // 消除法的主要核心逻辑:
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // 取出字符
            char c = s.charAt(i);
            if (c == '(') {
                // 如果是'('，那么压栈
                stack.push(c);
            } else if (c == ')') {
                // 如果是')'，那么就尝试弹栈
                if (stack.empty()) {
                    // 如果弹栈失败，那么返回false
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

    /**
     * 栈中元素都相同时，实际上没有必要使用栈，只需要记录栈中元素个数。
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        // 当字符串本来就是空的时候，我们可以快速返回true
        if (s == null || s.length() == 0) {
            return true;
        }
        // 当字符串长度为奇数的时候，不可能是一个有效的合法字符串
        // 当字符串长度为奇数的时候，不可能是一个有效的合法字符串
        if (s.length() % 2 == 1) {
            return false;
        }
        // 消除法的主要核心逻辑:
        int leftBraceNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            // 取出字符
            char c = s.charAt(i);
            if (c == '(') {
                // 如果是'('，那么压栈
                leftBraceNumber++;
            } else if (c == ')') {
                // 如果是')'，那么就尝试弹栈
                if (leftBraceNumber <= 0) {
                    // 如果弹栈失败，那么返回false
                    return false;
                }
                --leftBraceNumber;
            }
        }
        return leftBraceNumber == 0;
    }

    public static void main(String[] args) {
        final Code02 code02 = new Code02();
        final boolean valid = code02.isValid("((()))((()))");
        final boolean valid2 = code02.isValid2("((()))((()))");

        System.out.println(valid);
        System.out.println(valid2);

    }
}
