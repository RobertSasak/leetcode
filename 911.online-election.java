/*
 * @lc app=leetcode id=911 lang=java
 *
 * [911] Online Election
 */

// @lc code=start
class TopVotedCandidate {

    ArrayList<Integer> winningTime;
    ArrayList<Integer> winningPerson;
    public TopVotedCandidate(int[] persons, int[] times) {
        winningTime = new ArrayList<Integer>();
        winningPerson = new ArrayList<Integer>();

        HashMap<Integer, Integer> h = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int leader = -1;
        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            int v = h.getOrDefault(p, 0) + 1;
            h.put(p, v);
            if (max <= v) {
                max = v;
                if (p != leader) {
                    winningTime.add(times[i]);
                    winningPerson.add(p);
                    leader = p;
                }
            }
        }
    }
    
    public int q(int t) {
        int index = search(winningTime, t, 1, winningTime.size());
        return winningPerson.get(index);
    }

    int search(ArrayList<Integer> a, int t, int s, int e) {
        if (s == e) {
            return s - 1;
        }
        int m = (s + e) / 2;
        if (a.get(m) <= t) {
            return search(a, t, m + 1, e);
        }
        return search(a, t, s, m);
    };
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
// @lc code=end

