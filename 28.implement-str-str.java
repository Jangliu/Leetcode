/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == ""){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }
        else{
            for(int i=0;i<haystack.length()-needle.length()+1;i++)
            {
                String temp = haystack.substring(i, i+needle.length());
                // Java字符串是否一致要调用equals()方法
                //不能直接用==，因为==在比较引用类型变量（例如String），比较的是两个对象的地址（即两个对象是否为同一个对象）。
                if(needle.equals(temp)){
                    return i;
                }
            }
            return -1;
        }
    }
}
// @lc code=end

