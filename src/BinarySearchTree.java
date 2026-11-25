public class BinarySearchTree {
    Node root;
    public void recurInsert(Integer val){
        root = doRecurInsert(val, root);
    }

    private Node doRecurInsert(Integer val, Node curr){
        if(curr == null){
            return new Node(val);
        }
        if(curr.getData().compareTo(val) > 0){
            curr.setLeft(doRecurInsert(val, curr.getLeft()));
        }
        else{
            curr.setRight(doRecurInsert(val, curr.getRight()));
        }
        return curr;
    }
    public int getHeight(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public int findCount(int value){
        Node curr = root;
        int count = 0;
        while(curr != null){
            count++;
            if(curr.getData().compareTo(value) == 0){
                return count;
            }
            else if(curr.getData().compareTo(value) < 0){
                curr = curr.getLeft();
            }
            else{
                curr = curr.getRight();
            }
        }
        return count;
    }
}