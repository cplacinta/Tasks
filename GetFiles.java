package Input_Output;

import java.io.*;
import java.util.*;

public class GetFiles {

    public static void main(String[] args) {

        BufferedReader br = null;
        PrintWriter pw = null;
        String line = "";
        int counter = 0;
        int counter2 = 0;
        String keyword = "christianity";

        try {
            br = new BufferedReader(new FileReader("oldtext.txt"));
            pw = new PrintWriter(new FileWriter("newtext.txt"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                pw.println(line);
                String[] arrayString = line.split("(?=[,.])|\\s+");
                for (String temp : arrayString) {
                    if (keyword.equals(temp.toLowerCase())) {
                        counter++;
                    }

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Done reading from the file!");
        System.out.println("The keyword: '" + keyword + "' appeared in the file " + counter + " times!");

    }
}
