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
        List<Integer> front = new ArrayList<>();
        List<Integer> back = new ArrayList<>();
        NestedInteger last = null;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                front.add(i);
            }
            if(s.charAt(i)==']'){
                back.add(i);
            }
        }
        for(int i=front.size()-1;i>=0;i--){
            int left = front.get(i);
            int right;
            if(i==front.size()-1){
                right = back.get(back.size()-1-i);
            }
            else{
                right = front.get(i+1);
            }
            String[] words = s.substring(left+1, right).split(",");
            NestedInteger temp = new NestedInteger();
            for(String w:words){
                temp.setInteger(Integer.valueOf(w));
            }
            if(last!=null){
                last.add(temp);
            }
            last=temp;
        }
        if(last==null){
            last.setInteger(Integer.valueOf(s));
        }
        return last;
    }
}
// @lc code=end

