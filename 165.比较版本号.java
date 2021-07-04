/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        String[] longer;
        String[] shorter;
        if(v1.length>=v2.length){
            longer=v1;
            shorter=v2;
        }
        else{
            shorter=v1;
            longer=v2;
        }
        int i=0;
        for(;i<Math.min(v1.length, v2.length);i++){
            int a=Integer.valueOf(v1[i]);
            int b = Integer.valueOf(v2[i]);
            if(a>b){
                return 1;
            }
            if(a<b){
                return -1;
            }
        }
        if(longer.length>shorter.length){
            for(;i<longer.length;i++){
                if(Integer.valueOf(longer[i])>0){
                    if(longer.length==v1.length){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
            }
        }
        return 0;
    }
}
// @lc code=end

