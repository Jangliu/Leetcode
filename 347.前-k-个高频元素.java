import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 总的时间复杂度为O(n)
        int[] ans= new int[k];
        //基于桶排序求解「前 K 个高频元素」
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }
        int count=0;
        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i=list.length-1;i>=0;i--){
            if(list[i]!=null){
                for(int j=0;j<list[i].size();j++){
                    ans[count++]=list[i].get(j);
                    if(count==k){
                        break;
                    }
                }
                if(count==k){
                    break;
                }
            }
        }
        return ans;
    }
}


// @lc code=end

