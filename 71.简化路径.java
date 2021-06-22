import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        StringBuffer buffer = new StringBuffer();
        List<String> s = new ArrayList<>();
        String[] parts = path.split("/");
        for (String str : parts) {
            if (str.equals(".")) {
                continue;
            }
            if (str.equals("..")) {
                if (s.size() > 0) {
                    s.remove(s.size() - 1);
                    continue;
                } else {
                    continue;
                }

            }
            if (!str.equals("")) {
                s.add(str);
            }
        }
        if (s.size() == 0) {
            return "/";
        }
        for (int i = 0; i < s.size(); i++) {
            buffer.append("/");
            buffer.append(s.get(i));
        }
        return buffer.toString();
    }
}
// @lc code=end

