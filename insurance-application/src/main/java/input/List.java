package input;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;

public class List {
    public ListNode head;
    protected ListNode tail;
    protected int size = 0 ;

    //Creates an empty list
    public List(){
        head = null ;
        tail = null ;
        size = 0;
    }

    public int getSize(){ return size;}

    public void insert(String id, String pl, LocalDate day){
        ListNode node = new ListNode(id,pl,day); //create the new node
        if(head == null){
            head = node ;
            tail = node ;
          //  System.out.println("done");
        }
        else{
            node.setNext(head);
            head.setPrevious(node);
            head = node ;
        //    System.out.println("done2");
        }
        size++;
    }


   //Printing on screen
    public void print() {
        ListNode n = head;
        while (n != null) {
            n.print();          // Every node prints itself
            n = n.getNext();
        }
    }


}


