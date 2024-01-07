class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Node> rawList = new LinkedList<>();
        int size = intervals.length;

        for (int i = 0; i < size; i++) {
            rawList.add(new Node(intervals[i][0], intervals[i][1]));
        }
        rawList.add(new Node(newInterval[0], newInterval[1]));

        rawList.sort(Comparator.comparingInt(prev -> prev.st));

        List<Node> list = new LinkedList<>();
        list.add(rawList.get(0));

        for (int i = 1; i < size + 1; i++) {
            Node prev = list.get(list.size() - 1);

            if (prev.end >= rawList.get(i).st) {
                prev.end = Math.max(prev.end, rawList.get(i).end);
            } else {
                list.add(rawList.get(i));
            }
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i).st;
            ans[i][1] = list.get(i).end;
        }
        return ans;
    }

    private class Node {
        int st;
        int end;

        public Node(int _st, int _end) {
            st = _st;
            end = _end;
        }
    }

}