/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    
    HashMap<String, PriorityQueue<String>> h;
    List<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        h = new HashMap<>();
        result = new LinkedList<>();

        for (List<String> t : tickets) {
            String from = t.get(0);
            String to = t.get(1);
            h.putIfAbsent(from, new PriorityQueue<String>());
            h.get(from).add(to);
        }
        dfs("JFK");
        return result;
    }

    void dfs(String city) {
        if (city == null) {
            return;
        }
        PriorityQueue<String> q = h.getOrDefault(city, new PriorityQueue<String>());
        while (!q.isEmpty()) {
            dfs(q.poll());
        }
        result.add(0, city);
    }
}
// @lc code=end

