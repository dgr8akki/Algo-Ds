package Leetcode;

class Solution {
  public int searchInsert(int[] nums, int target) {
    int expected = Arrays.binarySearch(nums, target);
    if (expected >= 0)
      return expected;
    return (-1 * expected) - 1;
  }
}