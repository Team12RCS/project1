package input;
import input.List;
import input.ListNode;
import java.util.Scanner;


public class Fine {
    public static void cost(List eL) {
        Scanner sc = new Scanner(System.in);
        Double fcost;

        System.out.println("Give the fine cost");
        fcost = Double.valueOf(sc.next());
        //System.out.println(fcost);


        int i, j;
        int counter = 0;
        int length = eL.getSize();
        String[] Arr1 = new String[length];
        String[] Plate = new String[length];
        String s1;

        for (i = 0; i < length; i++) {
            Arr1[i] = eL.head.getTid();
            Plate[i] = eL.head.getPlate();
            eL.head = eL.head.getNext();
        }


        for (i = 0; i < length; i++) {
            double total = fcost;
            s1 = Plate[i];
            for (j = i + 1; j < length - 1; j++) {
                if (Arr1[j + 1].equals(Arr1[i])) {
                    if (!(s1.contains(Arr1[j + 1])))
                        s1 = s1 + " " + Plate[j + 1];

                    counter++;
                    total = total + fcost;

                }
            }

            System.out.println("TaxId " + Arr1[i] + " total cost " + total);
            counter = 0;
        }

    }
}



