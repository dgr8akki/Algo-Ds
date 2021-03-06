package Leetcode;

class Solution_1108_DefangingIP {
  public String defangIPaddr(String address) {
    StringBuilder builder = new StringBuilder();
    for (char c : address.toCharArray())
      if (c == '.')
        builder.append("[.]");
      else
        builder.append(c);
    return builder.toString();
  }
}
