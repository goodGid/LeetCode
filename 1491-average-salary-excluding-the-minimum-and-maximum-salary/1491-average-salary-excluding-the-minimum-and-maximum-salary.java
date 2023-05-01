class Solution {
    public double average(int[] salary) {
        double sum = 0;

        Arrays.sort(salary);

        int size = salary.length;

        for (int i = 1; i < size - 1; i++) {
            sum += salary[i];
        }

        return sum / (size - 2);
    }
}