class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int sum = 0;
        int aCnt = costs.length / 2;
        int bCnt = aCnt;
        
        List<Node> idxList = new ArrayList<>();
        
        for (int i=0; i<costs.length; i++) {
            idxList.add(new Node(i,Math.abs(costs[i][0] - costs[i][1])));
        }
        
        Collections.sort(idxList);
        
        for (Node i:idxList) {
            int a = costs[i.index][0];
            int b = costs[i.index][1];
            
            if (a == b) {
                sum += a;
            } else if (a > b) { // Pick 'A'
                if (bCnt - 1 >= 0) {
                    bCnt --;
                    sum += b;
                } else {
                    aCnt --;
                    sum += a;
                }
            } else { // Pick 'B' 
                if (aCnt - 1 >= 0) {
                    aCnt --;
                    sum += a;
                } else {
                    bCnt --;
                    sum += b;
                }
            }
        
        }
      
        return sum;
    }
}

    public class Node implements Comparable<Node> {
     int index;
     int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    

        @Override
        public int compareTo(Node newNode) {
            return newNode.value - value;
        }
    }