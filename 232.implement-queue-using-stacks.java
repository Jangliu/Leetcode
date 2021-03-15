import java.util.Stack;

/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {
    Stack<Integer> queue;
    int front;
    int count=0;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.queue=new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(this.queue.empty()){
            front=x;
        }
        this.queue.push(x);
        count++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (count <= 1) {
            this.front = 0;
            count--;
            return this.queue.pop();

        }
        int[] nums = new int[count - 1];
        for (int i = 0; i < count - 1; i++) {
            nums[i] = this.queue.pop();
        }
        this.front = nums[count - 2];
        int out = this.queue.pop();
        for (int i = count - 2; i >= 0; i--) {
            this.queue.push(nums[i]);
        }
        count--;
        return out;
    }
    
    /** Get the front element. */
    public int peek() {
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.queue.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

