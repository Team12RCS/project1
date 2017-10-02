package input;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import connection.MysqlCon;
import Freader.InputCsv2;
import output.PrintList;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        String plate;
        Scanner sc = new Scanner(System.in) ;

        char quit = 'n';
        String input;
        int choice ;

        Scanner in = new Scanner(System.in);

        String q = "F4";

        while (quit != 'y') {

            System.out.println("1\t Insurance Status of a vehicle");
            System.out.println("2\t List of Vehicles about to expire");
            System.out.println("3\t Sorting the plates-numbers");
            System.out.println("4\t Calculation of fine");

            System.out.println("Please enter your choice:");

            //Get user's choice
            choice = in.nextInt();

            //Display the title of the chosen module
            switch (choice) {
                case 1:
                    System.out.println("Insurance status");

                    System.out.println ("Please enter a specified plate");

                    Scanner scan = new Scanner (System.in);
                    plate = scan.nextLine();
                    Status plate3 = new Status ( );
                    plate3.getUserInput (plate,scan);

                    String filepath = "src\\main\\resources\\VehiclesDb2.csv";
                    String searchTerm = plate;
                    InputCsv2 dataFromCsv=new InputCsv2();
                    dataFromCsv.readNSearchCsv(searchTerm,filepath);

                    break;
                case 2:
                    System.out.println("List of vehicles");
                    Exp d1 = new Exp();
                    List myList = new List();
                    //q="F2";
                    myList=d1.reading(q);

                      PrintList.print(d1.ExpList);

                     break;
                case 3:
                    System.out.println("Sorted plates");
                    MysqlCon c = new MysqlCon();
                    c.Conpr();
                    break;
                case 4:
                    Exp d2 = new Exp();
                    List myL = new List();
                    myList=d2.reading(q);
                    System.out.println("Fine calculation");
                    Fine.cost(d2.ExpiredL);
                    break;
                default:
                    System.out.println("Invalid choice");
                }
            System.out.println("Would you like to quit y/n? ");
            input = in.next().toLowerCase();
            quit = input.charAt(0);
        }
    }
}
