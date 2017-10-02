package output;

import input.* ;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class PrintList {

   public static void print(List expL){
      Scanner sc = new Scanner(System.in);
      System.out.println("Export List to file? Y/N?");
      try {
         String s = sc.next();
         if (s.equals("Y") || s.equals("y")) {
            //File print
          //  expL.print();
            FPrint.FilePrint(expL);


         } else if (s.equals("N") || s.equals("n")) {
            //Console print
            expL.print();
         }
      }catch(InputMismatchException IME){

      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}
