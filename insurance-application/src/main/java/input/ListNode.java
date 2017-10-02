package input;

import java.time.LocalDate;
import java.util.Date;

public class ListNode {
      private String tax_id;
      private String plate;
      private LocalDate expDate;


      private ListNode previous;
      private ListNode next;

      //Constructor
    public ListNode(String tax_id, String plate,LocalDate day){
        this.tax_id = tax_id ;
        this.plate = plate ;
        this.expDate = day;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    public void setPrevious(ListNode previous) {
        this.previous = previous;
    }

    public String getTid() { return tax_id; }

    public String getPlate() { return plate; }

    public LocalDate getexpDate() {return expDate; }

    public void print(){
        String s = "TAX_ID " +tax_id+ " PLATE " +plate+" EXPIRATION DATE "+expDate ;
        System.out.println(s);
    }
    public String printF(){
        String s = "TAX_ID " +tax_id+ " PLATE " +plate+" EXPIRATION DATE "+expDate  ;
        return s;
    }
}

