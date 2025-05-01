class Solution {
    public int nthUglyNumber(int n) {
        // Array to store the first 'n' ugly numbers
        int[] ugly = new int[n];
        ugly[0] = 1; // First ugly number is always 1

        // Pointers to track the position for multiples of 2, 3, and 5
        int i2 = 0, i3 = 0, i5 = 0;

        // Initial next multiples of 2, 3, and 5
        int next2 = 2;  // ugly[i2] * 2
        int next3 = 3;  // ugly[i3] * 3
        int next5 = 5;  // ugly[i5] * 5

        // Generate ugly numbers from 1 to n
        for (int i = 1; i < n; i++) {
            // Choose the smallest among next2, next3, and next5
            int next = Math.min(next2, Math.min(next3, next5));

            // Store it in the ugly array
            ugly[i] = next;

            // If the chosen number was next2, move the i2 pointer forward
            if (next == next2) {
                i2++;                        // Move to next index
                next2 = ugly[i2] * 2;       // Update next multiple of 2
            }

            // Similarly update for 3
            if (next == next3) {
                i3++;
                next3 = ugly[i3] * 3;
            }

            // Similarly update for 5
            if (next == next5) {
                i5++;
                next5 = ugly[i5] * 5;
            }
        }

        // The last element in the array is the nth ugly number
        return ugly[n - 1];
    }
}
