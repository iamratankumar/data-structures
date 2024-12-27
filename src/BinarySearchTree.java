import java.util.Iterator;

import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T>{



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
    //BST traverse ORDERS. can be used as parameters.
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

    void remove(T value){
        if(root == null) throw new IllegalStateException("Tree is Empty");
        if(contains(value)){

            remove(root, value);
            size--;
            return;
        }
        throw new NoSuchElementException("No such value exists: "+ value);
    }

    Node remove(Node node, T val){
        if(node == null) return node;

        if(val.compareTo(node.value)<0) node.left = remove(node.left, val);
        else if(val.compareTo(node.value)>0) node.right = remove(node.right, val);
        else{
            if(node.left == null) return node.right;
            else if(node.right == null) return node.left;
            else{
                /*
                * In our Case we are replacing with next smallest from right node
                * and that'll be the next successor.
                * */
                Node successor = findSuccessor(node.right);
                node.value = successor.value;
                node.right = remove(node.right, successor.value);
            }
        }
        return node;
    }

    //This will find next smallest successor
    private Node findSuccessor(Node curr){
        if(curr.left != null) curr = curr.left;
        return curr;
    }

    boolean contains(T value){
        return contains(root, value) != null;
    }

    private Node contains(Node node,T val){
        if(node == null || val.compareTo(node.value) ==0)
            return node;

        if(val.compareTo(node.value)>0)
            return contains(node.right,val);

        return contains(node.left, val);
    }



    ArrayList<T> traverse(ORDER order){
        if(root == null) throw  new IllegalStateException("Tree is empty");
        ArrayList<T> list = new ArrayList<>();
        switch (order){
            case INORDER -> inOrder(root,list);
            case PREORDER -> preOrder(root,list);
            case POSTORDER -> postOrder(root,list);
            default -> throw new IllegalArgumentException("Invalid Order");
        }
        return list;
    }

    private void inOrder(Node node, ArrayList<T> list){
        if(node == null) return;
        inOrder(node.left,list);
        list.add(node.value);
        inOrder(node.right,list);
    }
    private void preOrder(Node node, ArrayList<T> list){
        if(node == null) return ;
        list.add(node.value);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }
    private void postOrder(Node node, ArrayList<T> list){
        if(node == null) return;
        postOrder(node.left,list);
        postOrder(node.right, list);
        list.add(node.value);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private final ArrayList<T> tree  = traverse(ORDER.INORDER);
            private int i=0;
            @Override
            public boolean hasNext() {
                return i<tree.size();
            }

            @Override
            public T next() {
                if(!hasNext()) throw new NoSuchElementException();
                return tree.get(i++);
            }
        };
    }



}
