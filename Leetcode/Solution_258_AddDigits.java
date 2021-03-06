package Leetcode;

class Solution_258_AddDigits {
  static int addDigits2(int num) {
    if (num == 0) {
      return 0;
    }
    if (num % 9 == 0) {
      return 9;
    } else {
      return num % 9;
    }
  }

  private static int addDigits(int num) {
    if (num < 10) {
      return num;
    }
    int sum = 0;
    int temp = num;
    while (temp > 0) {
      sum += (temp % 10);
      temp /= 10;
    }
    return Solution_258_AddDigits.addDigits(sum);
  }
}
