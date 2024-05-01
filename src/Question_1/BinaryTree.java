/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author xhu
 */
public class BinaryTree <E, F extends Comparable> {
    private Node root;
    private int number_of_nodes;
    private Node[] nodeList;
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Random rand = new Random();
        for (int i = 0; i <= 10; i++) {
            tree.addElement(null, rand.nextInt(100));
        }
        System.out.println("In Order:");
        tree.traversal();
        System.out.println("Reverse Order:");
        tree.reverseOrder();
        tree.traversal();
    }
    
    public BinaryTree(Node node)
    {
        this.root = node;
        this.number_of_nodes = 1;
        this.nodeList[0] = root;
    }
    
    public BinaryTree(E element, F key)
    {
        Node newNode = new Node(element, key);
        this.root = newNode;
        this.number_of_nodes = 1;
        this.nodeList[0] = root;
    }
    
    public BinaryTree()
    {
        this.root = null;
        this.number_of_nodes = 0;
        this.nodeList = null;
    }
    
    public void addElement(E element, F key)
    {
        Node newNode = new Node(element, key);
        this.addNode(this.root, newNode);
    }
    
    public boolean addNode(Node root, Node node)
    {        
        boolean found = false;
        Node current = root;
        if (root == null) {
            this.root = node;
        }
        
        while (!found && current != null) {
            int x = node.compareTo(current);
            if (x == 0) {
                return false;
            }
            else if (x > 0) {
                if (current.getRight() == null) {
                    current.setRight(node);
                    found = true;
                }
                else {
                    current = current.getRight();
                }
            }
            else {
                if (current.getLeft() == null) {
                    current.setLeft(node);
                    found = true;
                }
                else {
                    current = current.getLeft();
                }
            }
        }
        this.number_of_nodes++;
        return true;
    }
    
    //for your debugging
    public void traversal()
    {
        ArrayList<Node> output = new ArrayList();
        recTraversal(root, output);
        for (Node node : output) {
            System.out.println(node.toString());
        }
    }
    
    public void recTraversal(Node current, ArrayList<Node> output) {
        if (current == null) return;
        recTraversal(current.getLeft(), output);
        output.add(current);
        recTraversal(current.getRight(), output);
    }
    
    public Node[] toSortedList()
    {
        return null;
    }
    
    private void toSortedList(Node root)
    {


    }
    
    public E searchElement(F key)
    {
        return null;
    }
       
    public Node searchNode(Node root, Node node)
    {
        return null;
    }
    
    public void reverseOrder()
    {
        recReverseOrder(root);
    }
    
    private void recReverseOrder(Node current)
    {
        if (current == null) return;
        recReverseOrder(current.getLeft());
        recReverseOrder(current.getRight());
        current.swapChildren();
    }
       
}
