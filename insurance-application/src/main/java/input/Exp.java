package input;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Exp {
    private static String taxId;
    private static String expDate;
    private static String plate;

    public List ExpList  = new List();
    public List ExpiredL = new List();



    public Exp(){
        this.taxId = null;
        this.expDate = null ;
        this.plate = null;
     }


    public static String getTaxId() {
        return taxId;
    }

    public void setTaxId(String afm) {
        this.taxId = afm;
    }

    public static String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public static String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    //------------ ????? ---------//
    public String toString() {
        return "ExpDate(afm " + getTaxId() + " expDate " + getExpDate() + " plate " + getPlate() + ")";
    }
    //----------------------------//

    Scanner sc = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    public int timeframe() {
        int xr;
        System.out.println("Give the timeframe");
        do {
            xr = sc2.nextInt();
        } while (xr < 0);
        return xr;
    }

    public List reading(String q) throws ParseException {
        // final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fileName = "src\\main\\resources\\VehiclesDataNEW.csv";
        //List ExpList = new List();

        int tf = timeframe();

        LocalDate today = LocalDate.now();
        long p;

        //-------------READING FROM FILE-------------------------------//
        try {
            sc = new Scanner(new File(fileName));
            sc.useDelimiter("[;\n]");
            while (sc.hasNext()) {
                setPlate(sc.next());
                setTaxId(sc.next());
                setExpDate(sc.next().trim());
                String strDate = getExpDate();

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");


                LocalDate localDate = LocalDate.parse(strDate, dateTimeFormatter);

                p = ChronoUnit.DAYS.between(today,localDate);


                if (p > tf) {
                   // System.out.println("Lhgei se " + p + " meres ektos timeframe");
                }
                else if (p > 0 && p <= tf) {
                  //  System.out.println("Mesa sto timeframe=" + tf + " ,lhgei se " + p + "meres");
                    ExpList.insert(getTaxId(),getPlate(),localDate);

                }
                if (p <= 0) {
                 //   System.out.println("elhxe prin " + p * (-1) + " meres");
                    //FINAL COST//-------- F4 -------- //
                    ExpiredL.insert(getTaxId(),getPlate(),localDate);


                //-------i=i+1
                }
            }
            if (sc.next().contains(";;")) {
                sc.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException f) {
            //I don't care --- do nothing
        }

        if(q.equals("F2")){
            return ExpList;
        }
        else if (q.equals("F4")){
            return ExpiredL;
        }
        else{
            return ExpiredL;
        }
    }
}



