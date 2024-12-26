public class BinarySearchTree<T extends Comparable<T>> {

    private class Node{
        T value;
        Node left,right;

        Node(T value){
            this.value = value;
        }
        Node(T value, Node left, Node right){
            this.value =value; this.left =left; this.right = right;
        }

    }
    public enum ORDER{PREORDER,POSTORDER, INORDER}

    private Node root;
    private int  size;

    BinarySearchTree(){
        this.root = null;
        this.size =0;
    }

    void insert(T value){
        if(root == null){
            root = new Node(value);
            size++;
            return;
        }
        insert(root,value);
        size++;

    }

    Node insert(Node node,T val){
        if(node == null) return new Node(val);
        if(val.compareTo(node.value)<0) node.left = insert(node.left, val);
        else if(val.compareTo(node.value)>0) node.right = insert(node.right,val);
        return node;
    }
    T search(T value){
        return search(root, value).value;
    }

    Node search(Node node,T val){
        if(node == null || val.compareTo(node.value) ==0)
            return node;

        if(val.compareTo(node.value)>0)
            return search(node.right,val);

        return search(node.left, val);
    }


    void traverse(ORDER order){
        if(order == ORDER.INORDER)
            inOrder(root);
        else if (order == ORDER.POSTORDER)
            postOrder(root);
        else if (order == ORDER.PREORDER)
            preOrder(root);
        System.out.println();
    }
    private void inOrder(Node node){
        if(node == null) return;

        inOrder(node.left);
        System.out.printf("%s ",node.value);
        inOrder(node.right);
    }
    private void preOrder(Node node){
        if(node == null ) return;

        System.out.printf("%s ", node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    private void postOrder(Node node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.printf("%s ",node.value);
    }



}
