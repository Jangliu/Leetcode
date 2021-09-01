import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=373 lang=java
 *
 * [373] 查找和最小的K对数字
 */

// @lc code=start
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 以nums1=[1,7,11],nums2=[2,4,6]为例
        // 首先获得一个升序排列的数对队列
        // [[1,2],[1,4],[1,6]]
        // [[7,2].[7,4],[7,6]]
        // [[11,2].[11,4].[11,6]]
        // 首先维护一个小顶堆（最小的放在堆顶）
        // 将三个生序排列的数对队列的第一个元素放入小顶堆中
        // 这样就可以保证，放入后，堆顶的元素一定是所有要求元素里面最小的那个
        // 然后将堆顶元素取出，放入到答案集合，再将堆顶元素所在数对队列的下一个元素放入堆中（如果有，如果没有的话就不放入），这样就可以保证，第二小的元素一定在堆中
        // 重复取出元素和放入元素的步骤K次，即可保证最小的K对答案被取出
        int n1 = nums1.length, n2 = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]));
        List<List<Integer>> result = new ArrayList<>();

        if (n1 == 0 || n2 == 0 || k == 0) {
            return result;
        }
        for (int i = 0; i < n1; i++) {
            pq.offer(new int[] { i, 0 });
        }

        while (pq.size() > 0 && k > 0) {
            int[] pair = pq.poll();
            if (pair[1] + 1 < n2) {
                pq.offer(new int[] { pair[0], pair[1] + 1 });
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[pair[0]]);
            temp.add(nums2[pair[1]]);
            result.add(temp);
            k--;
        }

        return result;
    }
}

// @lc code=end

