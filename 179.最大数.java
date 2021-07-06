import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        // 将所有元素转成字符串
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 降序排列
        // 这个降序是重载过的
        // 这样排序的原理：
        // 如果xy(x拼在y前面)>yx，那么在排序中x一定要放在y的前面
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                // String的compareTo()方法会按照每个字符的ASCII码大小比较两个字符串
                // 对于两个字符串都是从头开始遍历顺序比较
                // 如果相等则继续比较，如果不相等，则返回该处两个字符的ASCII码差值
                return yx.compareTo(xy);
            }
        });

        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        for (String num : strs) {
            sb.append(num);
        }
        return sb.toString();
    }
}
// @lc code=end

