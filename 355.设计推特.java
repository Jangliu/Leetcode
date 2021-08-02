import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=355 lang=java
 *
 * [355] 设计推特
 */

// @lc code=start
class Twitter {
    HashMap<Integer,HashSet<Integer>> userTwitters;
    HashMap<Integer,HashSet<Integer>> followed;
    List<Integer> allTwitters;
    HashMap<Integer,Integer> twitterUser;
    /** Initialize your data structure here. */
    public Twitter() {
        userTwitters = new HashMap<>();
        followed = new HashMap<>();
        allTwitters = new ArrayList<>();
        twitterUser = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(userTwitters.containsKey(userId)){
            userTwitters.get(userId).add(tweetId);
        }
        else{
            HashSet<Integer> temp = new HashSet<>();
            temp.add(tweetId);
            userTwitters.put(userId, temp);
        }
        twitterUser.put(tweetId, userId);
        allTwitters.add(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res= new ArrayList<>();
        for(int i=allTwitters.size()-1;i>=0;i--){
            int id = allTwitters.get(i);
            if(userTwitters.containsKey(userId)){
                if(userTwitters.get(userId).contains(id)){
                    res.add(id);
                    if(res.size()>=10){
                        break;
                    }
                    else{
                        continue;
                    }
                }
            }
            if(followed.containsKey(userId)){
                if(followed.get(userId).contains(twitterUser.get(id))){
                    res.add(id);
                }
            }
            if(res.size()>=10){
                break;
            }
        }
        return res;
    }
    
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followed.containsKey(followerId)){
            followed.get(followerId).add(followeeId);
        }
        else{
            HashSet<Integer> temp = new HashSet<>();
            temp.add(followeeId);
            followed.put(followerId, temp);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followed.containsKey(followerId)){
            if(followed.get(followerId).contains(followeeId)){
                followed.get(followerId).remove(followeeId);
            }
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

