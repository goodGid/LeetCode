// from : 정답코드를 지피티한테 리팩토링 시킨 코드
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Node 클래스 삭제 및 기능 이동
        List<List<Integer>>[] dp = new ArrayList[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = new ArrayList<>();
        }

        // 0을 만들기 위해서는 아무런 요소도 사용할 필요가 없음
        dp[0].add(new ArrayList<>());

        // 후보군마다 조합을 만듦
        for (int candidate : candidates) {
            for (int i = candidate; i <= target; i++) {
                for (List<Integer> combination : dp[i - candidate]) {
                    List<Integer> newCombination = new ArrayList<>(combination);
                    newCombination.add(candidate);
                    dp[i].add(newCombination);
                }
            }
        }

        return dp[target];
    }
}
