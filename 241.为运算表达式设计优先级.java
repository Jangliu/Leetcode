import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 */

// @lc code=start
class Solution {
    Map<String, List<Integer>> map = new HashMap();
    // 分治思想
    // 每遇到一个操作符，就将操作符两边的式子当成一个新的式子传入本函数中
    // 然后迭代
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() <= 0) {
            return new ArrayList<Integer>();
        }
        if (map.containsKey(input)) return map.get(input);
        List<Integer> curRes = new ArrayList<Integer>();
        int length = input.length();
        char[] charArray = input.toCharArray();
        for (int i = 0; i < length; i++) {
            char aChar = charArray[i];
            if (aChar == '+' || aChar == '-' || aChar == '*') { // 当前字符为 操作符
                List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(input.substring(i + 1));
                for (int leftNum : leftList) {
                    for (int rightNum : rightList) {
                        if (aChar == '+') {
                            curRes.add(leftNum + rightNum);
                        } else if (aChar == '-') {
                            curRes.add(leftNum - rightNum);
                        } else {
                            curRes.add(leftNum * rightNum);
                        }
                    }
                }
                
            }
        }

        if (curRes.isEmpty()) {
            curRes.add(Integer.valueOf(input));
        }
        map.put(input, curRes);
        return curRes;
    }
}
// @lc code=end

