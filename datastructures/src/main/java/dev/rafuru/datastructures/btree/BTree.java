package dev.rafuru.datastructures.btree;

public class BTree {

    private Node root;
    public void add(int value){
        root = insertRecursively(root, value);
    }

    /**
     * Visit left nodes, then root node, then right nodes
     * @param node root node
     */
    public void transverseInOrder(Node node){
        if(node != null){
            transverseInOrder(node.left);
            System.out.println(node.value);
            transverseInOrder(node.right);
        }
    }

    /**
     * Visit root node first, then left nodes and finally right nodes
     * @param node
     */
    public void transversePreOrder(Node node){
        if(node != null){
            System.out.println(node.value);
            transversePreOrder(node.left);
            transversePreOrder(node.right);
        }
    }

    /**
     * Visit left nodes, then right nodes and finally root node
     */
    public void transversePostOrder(Node node){
        if(node != null){
            transversePostOrder(node.left);
            transversePostOrder(node.right);
            System.out.println(node.value);
        }
    }

    public Node getRoot(){
        return root;
    }



    private Node insertRecursively(Node currentNode, int value){

        if(currentNode == null){
            return new Node(value);
        }

        if(currentNode.value > value){
            currentNode.left = insertRecursively(currentNode.left, value);
        }else if (currentNode.value < value){
            currentNode.right = insertRecursively(currentNode.right, value);
        }
        return currentNode;
    }

    
    
}

class Node{
    int value;
    Node left;
    Node right;

    public Node (int value){
        this.value = value;
        left = null;
        right = null;
    }

}