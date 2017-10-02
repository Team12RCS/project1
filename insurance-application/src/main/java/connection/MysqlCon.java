package connection;

import java.sql.*;
import java.util.ArrayList;
import input.Car;

import static output.Sort.bubbleSort;

public class  MysqlCon {

    //Constructor
    public MysqlCon() {
    }

    public void Conpr() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3001/project1", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from vehicles");

            while (rs.next())
            { //    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getDate(3));
                 }


            String s1 = "SELECT plate,exp_date FROM vehicles WHERE 1";
            rs = stmt.executeQuery(s1);

            ArrayList<Car> list= new ArrayList<>();


            while(rs.next()){
                Car car1 = new Car(rs.getString("plate"),rs.getString("exp_date"));
                list.add(car1);
            }


            //------Printing the array list unsorted -------------------//
            for(int i=0;i<list.size();i++){

                String pName = list.get(i).getPlate();
                String pPlate = list.get(i).getExpDate();
            }

            ArrayList<Car> sortedL = new ArrayList();
            sortedL = bubbleSort(list);
            System.out.println("List Sorted by plate number");
            for(int i=0;i<sortedL.size();i++) {
                String pName = sortedL.get(i).getExpDate();
                String pPlate = sortedL.get(i).getPlate();
                System.out.println(pName+", "+pPlate);
            }
            con.close();
            rs.close();
            stmt.close();


        } catch (Exception e) {
            System.out.println(e);
        }



    }


    }





