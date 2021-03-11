/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */
import java.util.Stack;
// @lc code=start
class MinStack {
    int min;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        this.min=Integer.MAX_VALUE;
        this.stack=new Stack<Integer>();
    }
    
    public void push(int x) {
        if(x<=min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
        //如果push放入的值比min还要小，那么就要放入两个。
        //即先放入之前的最小值，再放入现在的
        //这样方便pop()操作
    }
    
    public void pop() {
        if(stack.pop()==min){
            min=stack.pop();
        }
        //在进行pop()操作的时候，如果移出去的是最小值，那么下一个值就是之前的最小值，
        //因为之前这种情况放了两个值进去，所以需要移除两次，否则只需要移除一次。
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

