public class BST {
  public class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
    }
  }

  private Node root;

  private void printRootValue() {
    System.out.print(this.root.value);
  }

  public void insert(int val) {
    root = insert(root, val);
  }

  private Node insert(Node head, int val) {
    if (head == null) {
      return new Node(val);
    }
    if (val >= head.value)
      head.right = insert(head.right, val);
    else
      head.left = insert(head.left, val);
    return head;
  }

  public void createTree(int[] arr) {
    for (int el : arr)
      insert(el);
  }

  public void inorder() {
    inorderTraversal(this.root);
  }

  private void inorderTraversal(Node head) {
    if (head == null)
      return;
    inorderTraversal(head.left);
    System.out.print(head.value + " ");
    inorderTraversal(head.right);
  }

  public void preorder() {
    preorderTraversal(this.root);
  }

  private void preorderTraversal(Node head) {
    if (head == null)
      return;
    System.out.print(head.value + " ");
    preorderTraversal(head.left);
    preorderTraversal(head.right);
  }

  public void postorder() {
    postorderTraversal(this.root);
  }

  private void postorderTraversal(Node head) {
    if (head == null)
      return;
    postorderTraversal(head.left);
    postorderTraversal(head.right);
    System.out.print(head.value + " ");
  }

  public void searchInBST(int key) {
    if (search(this.root, key) == null) {
      System.out.println("NOT FOUND");
    } else {
      System.out.println("KEY FOUND" + search(this.root, key).value);
    }
  }

  private Node search(Node head, int k) {
    if (head == null || head.value == k)
      return head;
    if (k < head.value)
      head.left = search(head.left, k);
    else if (k > head.value)
      head.right = search(head.right, k);
    return null;
  }

  public Node delete(Node head, int k) {
    if (head == null) {
      System.out.println("Key not found");
      return head;
    }
    if (k < head.value)
      head.left = delete(head.left, k);
    else if (k > head.value)
      head.right = delete(head.right, k);
    else if (k == head.value) {
      if (head.left == null && head.right == null) head = null;
      else if (head.left == null && head.right != null)
        head = head.right;
      else if (head.left != null && head.right == null)
        head = head.left;
      else if (head.left != null && head.right != null) {
        Node nextInorderedNode = getNextInorderedNode(head.right);
        if (nextInorderedNode == null) head = head.left;
        else {
          head.value = nextInorderedNode.value;
          head.right = delete(head.right, nextInorderedNode.value);
        }
      }
    }
    return head;
  }

  private Node getNextInorderedNode(Node head) {
    if (head == null) return null;
    if (head.right == null && head.left == null) return head;
    Node node = getNextInorderedNode(head.left);
    return node == null ? head : node;
  }

  public void delete(int k) {
    this.root = delete(this.root, k);
  }

  public static void main(String[] args) {
    BST bst = new BST();
    int[] input = { -1, 2, 3, 1, 4, 12, 21, 11 };
    bst.createTree(input);
    bst.insert(100);
    bst.insert(10);
    bst.preorder();
    System.out.println();
    bst.inorder();
    System.out.println();
    bst.postorder();
    bst.searchInBST(-1);
    bst.delete(12);
    bst.preorder();
  }
}
