// from solution
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Map to track the frequencies of elements
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Min heap to track all the frequencies
        PriorityQueue<Integer> frequencies = new PriorityQueue<>(map.values());

        // Tracking the number of elements removed
        int elementsRemoved = 0;

        // Traversing all frequencies
        while (!frequencies.isEmpty()) {
            // Removing the least frequent element
            elementsRemoved += frequencies.peek();

            // If the number of elements removed exceeds k, return
            // the remaining number of unique elements
            if (elementsRemoved > k) {
                return frequencies.size();
            }
            frequencies.poll();
        }

        // We have removed all elements, so no unique integers remain
        // Return 0 in this case
        return 0;
    }
}