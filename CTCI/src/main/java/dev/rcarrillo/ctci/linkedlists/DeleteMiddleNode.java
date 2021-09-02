package dev.rcarrillo.ctci.linkedlists;

import dev.rcarrillo.ctci.linkedlists.util.LinkedList;

/**
 * Implement an algorithm to remove a node in the middle (any node but first or last), by providing only the access to the node to be deleted
 * Input removeNode(Node(6)) list:1,3,4,7,6,2 / result list : 1,3,4,7,2
 */
public class DeleteMiddleNode {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAll(1,3,4,7,6,2);
        LinkedList.Node node = list.getNode(6)
                .orElseThrow(RuntimeException::new);
       list.removeMiddleNode(node);
       System.out.println(list);
    }
}
