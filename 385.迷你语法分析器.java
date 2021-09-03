import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=385 lang=java
 *
 * [385] 迷你语法分析器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        List<NestedInteger> list = new ArrayList<>();
        char[] c = s.toCharArray();
        if(c[0]!='['){
            return NestedInteger(Integer.valueOf(s));
        }
        int i =0;
        while(i<c.length){
            if(c[i]=='['){
                NestedInteger temp = new NestedInteger();
                list.add(temp);
                int j =i+1;
                while(c[j]!='['&&c[j]!=']'){
                    j++;
                }
                String num = s.substring(i + 1, j);
                String[] nums = num.split(",");
                for (String n : nums) {
                    if (n.length() > 0) {
                        list.get(list.size(-1)).setInteger(Integer.valueOf(n));
                    }
                }
                if(c[j]==']'){
                    list.get(list.size()-2).add(list.get(list.size()-1));
                    list.remove(list.size()-1);
                }
            }
        }

    }
}
// @lc code=end

