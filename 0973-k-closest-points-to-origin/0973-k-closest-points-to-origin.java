// from : Accepted Solutions Runtime Distribution
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int [][] ans = new int [k][];
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)-> p2[0]*p2[0] + p2[1]*p2[1] - p1[0]*p1[0] - p1[1]*p1[1]);
        for(int [] p : points){
            pq.add(p);
            if(pq.size()>k)
                pq.poll();
        }
        int i=0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll();
        }
        return ans;
    }
}