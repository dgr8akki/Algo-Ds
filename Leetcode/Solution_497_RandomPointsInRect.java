package Leetcode;

import java.util.Random;
import java.util.TreeMap;

class Solution_497_RandomPointsInRect {

  private TreeMap<Integer, Integer> treeMap;
  private Random rand;
  private int areaSum;
  private int[][] myRects;

  public Solution_497_RandomPointsInRect(int[][] rects) {
    treeMap = new TreeMap<>();
    rand = new Random();
    myRects = rects;

    int rectIndex = 0;
    for (int[] rect : rects) {
      areaSum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
      treeMap.put(areaSum, rectIndex);
      rectIndex++;
    }
  }

  public int[] pick() {
    int randomNum = treeMap.ceilingKey(rand.nextInt(areaSum + 1));
    int[] curRect = myRects[treeMap.get(randomNum)];
    int leftBound = curRect[0];
    int rightBound = curRect[2];
    int bottomBound = curRect[1];
    int topBound = curRect[3];

    int pointX = leftBound + rand.nextInt(rightBound - leftBound + 1);
    int pointY = bottomBound + rand.nextInt(topBound - bottomBound + 1);
    return new int[] {pointX, pointY};
  }
}
