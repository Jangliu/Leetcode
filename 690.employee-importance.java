/*
 * @lc app=leetcode id=690 lang=java
 *
 * [690] Employee Importance
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> roster;

    public int getImportance(List<Employee> employees, int id) {
        roster = new HashMap<>();
        if (employees == null)
            return 0;
        for (Employee e : employees) {
            roster.put(e.id, e);
        }
        int val = 0;
        Queue<Employee> q = new LinkedList<>();
        q.add(roster.get(id));
        while (!q.isEmpty()) {
            Employee curr = q.poll();
            val += curr.importance;
            for (int subID : curr.subordinates) {
                q.add(roster.get(subID));
            }
        }
        return val;

    }
}
// @lc code=end

