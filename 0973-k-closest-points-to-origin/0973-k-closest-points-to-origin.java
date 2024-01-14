class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<Node> list = new LinkedList<>();
        
        for (int[] item : points) {
            int x = item[0];
            int y = item[1];
            int result = (int) Math.sqrt((int) Math.pow(x,2) + (int) Math.pow(y,2));
            list.add(new Node(item, (int) (Math.pow(x,2) + Math.pow(y,2))));
        }
        
        Collections.sort(list, (l1, l2) -> {
            return l1.val - l2.val;
        });
        
        int[][] ans = new int[k][2];
        for (int i=0; i<k; i++) {
            Node node = list.get(i);
            ans[i][0] = node.pos[0];
            ans[i][1] = node.pos[1];
        }
        return ans;
    }
    
    class Node {
        int[] pos;
        int val;
        
        public Node(int[] _pos, int _val) {
            pos = _pos;
            val = _val;
        }
    }
}