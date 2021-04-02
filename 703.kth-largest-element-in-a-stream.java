import java.util.ArrayList;

/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start
class KthLargest {
    PriorityQueue<Integer> pq;//PriorityQueue这个队列会默认按照顺序排里面的元素
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int i : nums) {
            this.add(i); // call class's own function, instead of repeating yourself
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) { // remove elements ONLY when heap size is too big
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

