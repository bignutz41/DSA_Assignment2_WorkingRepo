/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

/**
 *
 * @author xhu
 */
public class BinaryTree <E, F extends Comparable> {
    private Node root;
    private int number_of_nodes;
    private Node[] nodeList;
    
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
    public void traversal(Node root)
    {
        
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

    }
    
    private void reverseOrder(Node root)
    {

    }
       
}
