package input;

import java.util.Scanner;




public class Status {
    public String getUserInput(String plate,Scanner scan) {
        boolean error = true;

        while (!plate.matches ("[A,B,E,H,I,K,M,N,O,P,T,X,Y,Z][A,B,E,H,I,K,M,N,O,P,T,X,Y,Z][A,B,E,H,I,K,M,N,O,P,T,X,Y,Z]-[1-9][0-9][0-9][0-9]")) {
            System.out.println ("You entered a wrong format, please enter the plate again");
            plate = scan.nextLine ( );
        }
        System.out.println ("You want to know if " + plate + " is updated");
        return (String.valueOf(plate));
    }

}






