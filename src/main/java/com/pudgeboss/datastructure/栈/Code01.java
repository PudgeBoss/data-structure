package com.pudgeboss.datastructure.栈;

/**
 * 最小栈
 *
 * @author pudgeboss
 * @email pudgeboss@163.com
 * @date 2021-08-06 00:23
 */
public class Code01 {

    /**
     * 链表头，相当于栈顶
     */
    private ListNode head;

    /**
     * 压栈，需要判断栈是否为空
     *
     * @param x
     */
    public void push(int x) {
        if (empty())
            head = new ListNode(x, x, null);
        else
            head = new ListNode(x, Math.min(x, head.min), head);
    }

    /**
     * 出栈，相当于把链表头删除
     */
    public void pop() {
        if (empty())
            throw new IllegalStateException("栈为空……");
        head = head.next;
    }

    /**
     * 栈顶的值也就是链表头的值
     *
     * @return
     */
    public int top() {
        if (empty())
            throw new IllegalStateException("栈为空……");
        return head.val;
    }

    /**
     * 链表中头结点保存的是整个链表最小的值，所以返回head.min也就是
     * <p>
     * 相当于返回栈中最小的值
     *
     * @return
     */
    public int getMin() {
        if (empty())
            throw new IllegalStateException("栈为空……");
        return head.min;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    private boolean empty() {
        return head == null;
    }
}

class ListNode {
    public int val;
    //最小值
    public int min;
    public ListNode next;

    public ListNode(int val, int min, ListNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
