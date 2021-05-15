import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1656 lang=java
 *
 * [1656] Design an Ordered Stream
 */

// @lc code=start
class OrderedStream {
    private List<String> val;
    int index=0;
    public OrderedStream(int n) {
        this.val=new ArrayList<>();
        for(int i=0;i<n;i++){
            val.add(" ");
        }
    }
    
    public List<String> insert(int idKey, String value) {
        this.val.set(idKey-1, value);
        List<String> res = new ArrayList<>();
        for(int i=this.index;i<this.val.size();i++){
            if(this.val.get(i)==" "){
                break;
            }
            res.add(this.val.get(i));
            this.index++;
        }
        return res;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
// @lc code=end

