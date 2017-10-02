package output;

import java.util.ArrayList;
import input.Car;

public class Sort {
    public static ArrayList<Car> bubbleSort(ArrayList<Car> lista) {

        int n = lista.size();
        Car temp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (lista.get(j-1).compareTo(lista.get(j))==1) {
                    temp=lista.get(j-1);
                    lista.set((j-1),lista.get(j));
                    lista.set(j,temp);
                }
            }
        }
        return lista;
    }

}
