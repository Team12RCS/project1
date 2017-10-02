package Freader;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class InputCsv2 {
    public void readNSearchCsv(String searchTerm, String filepath) {
           Scanner x;
           boolean found = false;
           String taxId = "";
           String plate2 = "";
           String expDate="";
           try {
              x = new Scanner(new File(filepath));
              x.useDelimiter ("[;\n]");
              while (x.hasNext () && !found) {
                  taxId = x.next();
                  plate2 = x.next();
                  expDate = x.next();
                //the line below will be removed.. just checking the parser
               //System.out.println (plate2);
                   if (plate2.equals (searchTerm)) {
                      found = true;
                       //System.out.println ("boolean is "+found);
                      break;
                   }
               }
               if (found) {
                    System.out.println ("The plate "+plate2+" expires in "+expDate+"Belongs to "+taxId);
                    try {
                      DateFormat format = new SimpleDateFormat ("yyyy-MM-dd", Locale.ENGLISH);
                      Date exDate = format.parse (expDate);
                      LocalDate localDate = LocalDate.now();
                      Date currentDate = format.parse(String.valueOf(localDate));
                      if (currentDate.before (exDate)){
                         System.out.println ("Insurance Status: Updated till "+exDate);
                      }
                      else{
                        System.out.println ("Insurance Status: Expired since "+expDate);
                      }
                     //System.out.println (date);
                    }catch (ParseException e) {
                        e.printStackTrace ( ); }
               }
               else {
                  System.out.println ("The plate you asked does not exist");
               }

              }
              catch (FileNotFoundException e) {
                 System.out.println ("Error");
              }
    }
}

