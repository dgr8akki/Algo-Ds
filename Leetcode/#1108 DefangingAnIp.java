class Solution {
  public String defangIPaddr(String address) {
    StringBuilder builder = new StringBuilder();
    for (char current : address.toCharArray())
      if (current == '.')
        builder.append("[.]");
      else
        builder.append(current + "");
    return builder.toString();
  }
}
