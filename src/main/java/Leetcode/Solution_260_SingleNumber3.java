package Leetcode;

class Solution {
  public int[] singleNumber(int[] nums) {
    int aXORb = 0;
    for (int num : nums)
      aXORb ^= num;
    aXORb &= -aXORb;
    int[] res = new int[2];
    for (int num : nums) {
      if ((num & aXORb) == 0)
        res[0] ^= num;
      else
        res[1] ^= num;
    }
    return res;
  }
}