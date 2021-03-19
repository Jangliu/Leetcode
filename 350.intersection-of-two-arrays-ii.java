import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 =new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        ArrayList<Integer> r = new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++){
            if(!map1.containsKey(nums1[i])){
                map1.put(nums1[i], 1);
                continue;
            }
            map1.replace(nums1[i], map1.get(nums1[i])+1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!map2.containsKey(nums2[i])) {
                map2.put(nums2[i], 1);
                continue;
            }
            map2.replace(nums2[i], map2.get(nums2[i]) + 1);
        }
        map1.forEach((key,value)->{
            if(map2.containsKey(key)){
                int count = Math.min(map1.get(key), map2.get(key));
                for(int i=0;i<count;i++){
                    r.add(key);
                }
            }
        });
        int[] result =new int[r.size()];
        for(int i=0;i<r.size();i++){
            result[i]=r.get(i);
        }
        return result;
    }
}
// @lc code=end

