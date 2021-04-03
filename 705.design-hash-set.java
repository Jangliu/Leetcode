import java.util.ArrayList;

/*
 * @lc app=leetcode id=705 lang=java
 *
 * [705] Design HashSet
 */

// @lc code=start
class MyHashSet {
    ArrayList<Integer> val;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.val=new ArrayList<Integer>();
    }
    
    public void add(int key) {
        if(!this.val.contains(key)){
            this.val.add(key);
        }
    }
    
    public void remove(int key) {
        this.val.remove(Integer.valueOf(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return this.val.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

