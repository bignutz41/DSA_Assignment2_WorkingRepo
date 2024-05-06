/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

/**
 *
 * @author xhu
 */
public class Node {
    private String name;
    private int x;
    private int y;
    private int distanceToEnd;
    private Node left;
    private Node right;
    private Node parent;
    
    public Node(String name, int x, int y, Node left, Node right) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
    }
}
