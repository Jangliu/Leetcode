/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */
import java.util.LinkedList;
import java.util.Queue;
// @lc code=start
class MyStack {
    Queue<Integer> queue;
    int top;
    int length = 0;

    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.queue.offer(x);
        this.top = x;
        this.length++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> temp = new LinkedList<Integer>();
        for (int i = 0; i < this.length - 1; i++) {
            if (i == this.length - 2) {
                this.top = this.queue.poll();
                temp.offer(top);
            } 
            else {
                temp.offer(this.queue.poll());
            }
        }
        int result = this.queue.poll();
        this.length--;
        this.queue = temp;
        return result;

    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (this.queue.peek() != null) {
            return false;
        }
        return true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

