/*
 * @lc app=leetcode id=895 lang=java
 *
 * [895] Maximum Frequency Stack
 */

// @lc code=start
class FreqStack {
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> group;

    int max = 0;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
    }
    
    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);

        if (f > max) {
            max = f;
        }
        group.computeIfAbsent(f, z -> new Stack()).push(x);
    }
    
    public int pop() {
        if (max == 0) {
            return -1;
        }
        Stack<Integer> list = group.get(max);
        int r = list.pop();
        freq.put(r, freq.get(r) - 1);
        if (list.isEmpty()) {
            // group.remove(max);
            max--;
        }
        return r;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
// @lc code=end

