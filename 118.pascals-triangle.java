import java.util.ArrayList;

/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> rowone = new ArrayList<Integer>();
        ArrayList<Integer> rowtwo = new ArrayList<Integer>();
        rowone.add(1);
        rowtwo.add(1);
        rowtwo.add(1);
        switch (numRows) {
        case 1:
            allrows.add(rowone);
            return allrows;
        case 2:
            allrows.add(rowone);
            allrows.add(rowtwo);
            return allrows;
        default:
            allrows.add(rowone);
            allrows.add(rowtwo);
            for (int i = 3; i <= numRows; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(1);
                List<Integer> last = allrows.get(i - 2);
                for (int j = 0; j < last.size() - 1; j++) {
                    temp.add(last.get(j) + last.get(j + 1));
                }
                temp.add(1);
                allrows.add(temp);
            }
            return allrows;
        }
    }
}
// @lc code=end

