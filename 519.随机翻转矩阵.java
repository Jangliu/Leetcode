import java.util.HashMap;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=519 lang=java
 *
 * [519] 随机翻转矩阵
 */

// @lc code=start
class Solution {
    private final int M, N, CAPACITY;
    private int size;
    private Random random;
    private Map<Integer, Integer> map;
        
    public Solution(int m, int n) {
        M = m;
        N = n;
        CAPACITY = m * n;
        size = CAPACITY;
        random = new Random();
        map = new HashMap<>();
    }
    
    public int[] flip() {
        if (size <= 0) {
            return new int[]{-1, -1}; // or throw exception.
        }
        Integer rand = random.nextInt(size);
        size--;
        int idx = map.getOrDefault(rand, rand);
        Integer tail = map.getOrDefault(size, size);
        map.put(rand, tail);
        return new int[]{idx / N, idx % N};
    }
    
    public void reset() {
        map = new HashMap();
        size = CAPACITY;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
// @lc code=end

