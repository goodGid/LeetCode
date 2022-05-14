class Solution {
    public double findMedianSortedArrays(int[] n1, int[] n2) {

        int size = n1.length + n2.length;
        boolean isEven = size % 2 == 0;
        int mid = size / 2;

        int idx1 = 0;
        int idx2 = 0;
        int[] ansArr = new int[mid + 1];
        int ansArrIdx = 0;

        if (n1.length == 0) {
            if (isEven) {
                return (n2[mid] + n2[mid - 1]) / 2.0;
            } else {
                return n2[mid] / 1.0;
            }
        }

        if (n2.length == 0) {
            if (isEven) {
                return (n1[mid] + n1[mid - 1]) / 2.0;
            } else {
                return n1[mid] / 1.0;
            }
        }

        while (isRange(idx1, n1) && isRange(idx2, n2)) {
            if (idx1 + idx2 == mid + 1) {
                if (isEven) {
                    return (ansArr[ansArrIdx - 1] + ansArr[ansArrIdx - 2]) / 2.0;
                } else {
                    return ansArr[ansArrIdx - 1] / 1.0;
                }
            }
            if (n1[idx1] > n2[idx2]) {
                ansArr[ansArrIdx++] = n2[idx2];
                idx2++;
            } else {
                ansArr[ansArrIdx++] = n1[idx1];
                idx1++;
            }
        }

        while (isRange(idx1, n1)) {
            if (idx1 + idx2 == mid + 1) {
                if (isEven) {
                    return (ansArr[ansArrIdx - 1] + ansArr[ansArrIdx - 2]) / 2.0;
                } else {
                    return ansArr[ansArrIdx - 1] / 1.0;
                }
            }
            ansArr[ansArrIdx++] = n1[idx1];
            idx1++;
        }

        while (isRange(idx2, n2)) {
            if (idx1 + idx2 == mid + 1) {
                if (isEven) {
                    return (ansArr[ansArrIdx - 1] + ansArr[ansArrIdx - 2]) / 2.0;
                } else {
                    return ansArr[ansArrIdx - 1] / 1.0;
                }
            }
            ansArr[ansArrIdx++] = n2[idx2];
            idx2++;
        }

        return (ansArr[0] + ansArr[1]) / 2.0;
    }

    private boolean isRange(int idx, int[] arr) {
        return idx < arr.length;
    }
}