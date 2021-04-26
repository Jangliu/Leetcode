import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=1331 lang=java
 *
 * [1331] Rank Transform of an Array
 */

// @lc code=start
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        //注意数组要是直接用赋值的办法，那两个变量其实指向的是同一个元素
        //还可以用例子中的.clone()方法。
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        int index = 1;
        HashMap<Integer, Integer> val = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            if (!val.containsKey(temp[i])) {
                val.put(temp[i], index);
                index++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = val.get(arr[i]);
        }
        return arr;
    }
}
// @lc code=end

