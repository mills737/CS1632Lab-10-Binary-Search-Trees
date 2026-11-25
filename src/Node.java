public class Node {
     int val;
     Node left;
     Node right;
    public Node(int val){
        this.val = val;
        left = null;
        right = null;
    }

    public Comparable<Integer> getData() {
        return val;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
