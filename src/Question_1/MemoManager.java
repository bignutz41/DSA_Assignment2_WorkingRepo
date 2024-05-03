/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xhu
 */
public class MemoManager<E extends Comparable> {
    
    public BinaryTree bTreeDate;
    public BinaryTree bTreeTitle;
    
    public MemoManager() {
        this.bTreeDate = new BinaryTree();
        this.bTreeTitle = new BinaryTree();
    }
    
    public void addMemo(String date, String title, String message)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Memo memo = new Memo();
        try {
            //converting a string to date
            memo.date = dateFormat.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(MemoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        memo.title = title;
        memo.message = message;
        
        addToTree(memo, (E) memo.date);
        addToTree(memo, (E) memo.title);
    }
    
    public void addToTree(Memo memo, E key)
    {        
        
        if (key instanceof Date) {
            bTreeDate.addElement(memo, key);
        }
        else if (key instanceof String) {
            bTreeTitle.addElement(memo, key);
        }
    }
    
    public Memo findMemo(E key)
    {
        if (key instanceof Date) {
            return (Memo) bTreeDate.searchElement(key);
        }
        if (key instanceof String) {
            return (Memo) bTreeTitle.searchElement(key);
        }
        return null;
    }
    
    // test comment
    public Memo[] getSortedMemoList(E key)
    {   
        Memo[] memos = null;
        Node[] nodes = null;
        if (key instanceof Date) {
            nodes = bTreeDate.toSortedList();
            memos = new Memo[nodes.length];
        }
        else if (key instanceof String) {
            nodes = bTreeTitle.toSortedList();
            memos = new Memo[nodes.length];
        }
        
        if (nodes != null && memos != null) {
            int index = 0;
            for (Node node : nodes) {
                memos[index] = (Memo) node.getElement();
                index++;
            }
        }
        
        return memos;
    }
    
    public void reverseOrder()
    {
        bTreeDate.reverseOrder();
        bTreeTitle.reverseOrder();
    }    
}

/*

*/