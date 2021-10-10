class Solution {
    public int[] dailyTemperatures(int[] t) {
        int[] ans = new int[t.length];
        Stack<Pair> s = new Stack<>();
        
        for (int i=0; i<t.length; i++) {
            
            while (!s.empty()) {
                Pair topNode = s.peek();
                
                if (t[i] <= topNode.val) {
                    break;
                }
                
                if (t[i] > topNode.val) {
                    s.pop();
                    ans[topNode.idx] = i - topNode.idx;
                }
            }
            s.push(new Pair(i, t[i]));
        }
        return ans;
    }
    
    public class Pair {
        int idx;
        int val;
        
        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}