// 240107
// 정답 코드를 GPT에게 리팩토링 요청 
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 새로운 interval보다 작은 end를 갖는 모든 interval을 결과에 추가
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 겹치는 interval을 병합
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // 병합된 interval 결과에 추가
        result.add(newInterval);

        // 새로운 interval보다 큰 start를 갖는 모든 interval을 결과에 추가
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}