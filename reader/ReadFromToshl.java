package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class ReadFromToshl {
  public static void main(String[] args) throws IOException {


    HashSet<String> hs = new HashSet();
    String str;


    try (BufferedReader br = new BufferedReader(new FileReader("C:\\toshl.csv"))) {
      StringBuilder sb = new StringBuilder();
      String line = br.readLine();

      while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        int startIndex = line.indexOf(',') + 2;
        str = line.substring(startIndex, line.indexOf("\"", startIndex)).trim();
        if (str.contains(",")) {
          String[] tags = str.split(",");
          for (String tag : tags) {
            hs.add(tag.trim());
          }
        } else {
          hs.add(str);
        }
        line = br.readLine();
      }
    } catch (Exception ex) {
      System.out.print(ex);
    }
    hs.remove("Entry (tags)");
    System.out.println(hs);
  }
}
