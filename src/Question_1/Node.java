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
    private E memo;
    private F key;
    private Node left;
    private Node right;
    

    @Override
    public int compareTo(Node t) {
        return this.key.compareTo(t.getKey());
    }

    /**
     * @return the memo
     */
    public E getMemo() {
        return memo;
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
}
