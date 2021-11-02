class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        go(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void go(int[] arr, int target, List<List<Integer>> ans, List<Integer> tempAns, int idx) {

        // int sum = tempAns.stream().mapToInt(i -> i).sum();
        int sum = 0;
        for (int i : tempAns) {
            sum += i;
        }

        if (sum == target) {
            List<Integer> temp = new ArrayList<>();
            for (int i : tempAns) {
                temp.add(i);
            }
            ans.add(temp);
        } else if (sum > target) {
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            tempAns.add(arr[i]);
            go(arr, target, ans, tempAns, i);
            tempAns.remove(tempAns.size() - 1);
        }
    }
}