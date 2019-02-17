import com.processingFIle.MyFileUtils;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {

    /*    for(int i =0; i <= 3; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter some text:  ");
            String enteredText = input.nextLine();
            System.out.println(enteredText);
        }*/

        try {
            File file = new File("C:\\Users\\vaidi\\Desktop\\Guilded Rose Group\\GildedRose-Refactoring-Kata\\processingFIle\\src\\com\\processingFIle\\myfile.txt");
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
           // e.printStackTrace();
        }
        MyFileUtils myFileUtils = new MyFileUtils();
        try {

            System.out.println(myFileUtils.subract10FromLargeNumber(9));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
