/*
 * @lc app=leetcode id=1184 lang=java
 *
 * [1184] Distance Between Bus Stops
 */

// @lc code=start
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
       	int total = 0;
		for (int x : distance) {
			total = x + total;
		}

		int dis = 0;
		if(start<destination)
		for (int i = start; i < destination; i++) {
			dis = dis + distance[i];
		}
		else {
		
			for (int i = destination; i < start; i++) {
				dis = dis + distance[i];
			}
		}

		int ad = total - dis;

		if(ad<0)
		{
			ad=ad*-1;
		}
		return Math.min(dis, ad);

    }
}
// @lc code=end

