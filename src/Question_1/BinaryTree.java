/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
            int num = rand.nextInt(100);
            tree.addElement(num, num);
        }
        System.out.println("In Order:");
        tree.traversal();
        System.out.println("Reverse Order:");
        tree.reverseOrder();
        tree.traversal();
        System.out.println("Sorted List:");
        Node[] list = tree.toSortedList();
        for (Node node : list) {
            if (node == null) {
                System.out.println("null");
            }
            else {
                System.out.println(node.toString());
            }
        }
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Pick a key to search for: ");
        int input = Integer.parseInt(scan.nextLine());
        
        if (tree.searchElement(input) == null) {
            System.out.println("Element not in list");
        }
        else {
            System.out.println("Found! Element = " + tree.searchElement(input).toString());
        }
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
        ArrayList<Node> output = new ArrayList();
        
        recToSortedList(root, output);
        
        Node[] listOut = new Node[output.size()];
        nodeList = listOut;
        return output.toArray(listOut);
    }
    
    private void recToSortedList(Node current, ArrayList<Node> output)
    {
        if (current == null) return;
        recToSortedList(current.getLeft(), output);
        output.add(current);
        recToSortedList(current.getRight(), output);
    }
    
    public E searchElement(F key)
    {
        Node target = new Node(key);
        Node input = searchNode(root, target);
        if (input != null) {
            return (E) input.getElement();
        }
        else return null;
    }
       
    public Node searchNode(Node root, Node target)
    {
        boolean reversed = false;
        if (root.hasLeft()) {
            if (root.compareTo(root.getLeft()) < 0) {
                reversed = true;
            }
        }
        else {
            if (root.compareTo(root.getRight()) > 0) {
                reversed = true;
            }
        }
        
          
        boolean found = false;
        Node current = root;

        while (!found && current != null) {
            int x = target.compareTo(current);
            if (x == 0) {
                traversal();
                return current;
            }
            else if (x > 0) {
                if (reversed) {
                    current = current.getLeft();
                }
                else {
                    current = current.getRight();
                }
            }
            else if (x < 0) {
                if (reversed) {
                    current = current.getRight();
                }
                else {
                    current = current.getLeft();
                }
            }
        }
        traversal();
        return null;
    }
    public void reverseOrder()
    {
        recReverseOrder(root);
    }
    
    /*
    * Time Complexity Analysis:
    * The method visits each node exactly once. In each node, constant time operations are performed such as checking if the current node is null,
    * swapping its children, and recursive calls to its left and right children. Since each node is visited once, and the operations performed
    * at each node are constant time, the time complexity is O(n).
    */
    
    private void recReverseOrder(Node current)
    {
        if (current == null) return;
        recReverseOrder(current.getLeft());
        recReverseOrder(current.getRight());
        current.swapChildren();
    }
       
}
