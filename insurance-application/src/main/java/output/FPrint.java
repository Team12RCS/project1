package output;

import input.List;
import input.ListNode;

import java.io.FileWriter;
import java.io.IOException;

public class FPrint {

    public static void FilePrint(List mL) throws IOException {
        ListNode n = mL.head;
        FileWriter fileWriter = new FileWriter("C:\\Users\\theodora\\Desktop\\auto.txt");
        String LINE_SEPARATOR = System.getProperty("line.separator");

        try {
            fileWriter = new FileWriter("C:\\Users\\theodora\\Desktop\\auto.txt");
            System.out.println("Start typing...");
            for(int i=0;i<mL.getSize();i++){
                fileWriter.append(mL.head.printF());
                fileWriter.append(LINE_SEPARATOR);
                mL.head= mL.head.getNext();
            }
            System.out.println("Typing complete");

        } catch (Exception ee) {
            //
        }finally {
            try {
                fileWriter.close();
            } catch (IOException ie) {
                System.out.println("Error occured while closing the fileWriter");
                ie.printStackTrace();
            }
        }



    }
}
