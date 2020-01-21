/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start

// -2 -1 | -2 0 | -2 -2
class MinStack {
    Stack<Integer> s;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        s.push(x);
        if (x <= min) {
            min = x;
        }
        s.push(min);
    }
    
    public void pop() {
        s.pop();
        s.pop();
        if (s.empty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = s.peek();
        }
    }
    
    public int top() {
        int m = s.pop();
        int v = s.peek();
        s.push(min);
        return v;
    }
    
    public int getMin() {
        return s.peek();
    }
}


// non constant version
// class MinStack {
//     LinkedList<Integer> l;
    
//     /** initialize your data structure here. */
//     public MinStack() {
//         l = new LinkedList<Integer>();
//     }
    
//     public void push(int x) {
//         l.addFirst(x);
//     }
    
//     public void pop() {
//         l.poll();
//     }
    
//     public int top() {
//         return l.peek();
//     }
    
//     public int getMin() {
//         int min = Integer.MAX_VALUE;
//         for (int n : l) {
//             min = Math.min(min, n);
//         }
//         return min;
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

