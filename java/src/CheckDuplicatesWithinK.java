/**
 * Given an integer array arr[] and an integer k, determine whether there exist
 * two indices i and j
 * such that arr[i] == arr[j] and |i – j| ≤ k. If such a pair exists, return
 * 'Yes', otherwise return 'No'.
 *
 * Examples:
 *
 * Input: k = 3, arr[] = [1, 2, 3, 4, 1, 2, 3, 4]
 * Output: No
 * Explanation: Each element in the given array arr[] appears twice and the
 * distance between every element and its duplicate is 4.
 *
 * Input: k = 3, arr[] = [1, 2, 3, 1, 4, 5]
 * Output: Yes
 * Explanation: 1 is present at index 0 and 3.
 *
 * Input: k = 3, arr[] = [1, 2, 3, 4, 5]
 * Output: No
 * Explanation: There is no duplicate element in arr[].
 */

public class CheckDuplicatesWithinK {
    static String solution(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    if (Math.abs(i - j) <= k) {
                        System.out.println("Yes");
                        return "Yes";
                    }
                }
            }
        }
        System.out.println("No");
        return "No";
    }
}
