/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

import java.util.Date;

/**
 *
 * @author xhu
 */
public class Node <E, F extends Comparable> implements Comparable <Node>{
    private E element;
    private F key;
    private Node parent;
    private Node left;
    private Node right;
    
    public Node(E element, F key) {
        this.element = element;
        this.key = key;
        this.left = null;
        this.right = null;
    }
    
    public Node(F key) {
        this.element = null;
        this.key = key;
        this.left = null;
        this.right = null;
    }
    
    @Override
    public int compareTo(Node t) {
        return this.key.compareTo(t.getKey());
    }
    
    @Override
    public String toString() {
        return "Key: " + key.toString();
    }
    
    public void swapChildren() {
        Node temp = left;
        left = right;
        right = temp;
    }

    /**
     * @return the element
     */
    public E getElement() {
        return element;
    }

    /**
     * @return the key
     */
    public F getKey() {
        return key;
    }

    /**
     * @return the left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public Node getRight() {
        return right;
    }

    /**
     * @param element the element to set
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * @param key the key to set
     */
    public void setKey(F key) {
        this.key = key;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Node right) {
        this.right = right;
    }
}
