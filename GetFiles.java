package Input_Output;

import java.io.*;
import java.util.HashSet;

public class GetFiles {


    private static final String FILENAME = "oldtext.txt";

    // finds and returns max length of the word from a file
    static int maxWord() throws IOException {
        int maxWord = 0;
        FileReader fr = new FileReader("oldtext.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] arrayString = line.split("(?=[,.])|\\s+");
                for (String temp : arrayString) {
                    if (temp.length() > maxWord) {
                        maxWord = temp.length();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return maxWord;
    }

    // finds and returns the longest word from a file
    static String longestWord() throws IOException {
        String longestWord = "";
        FileReader fr = new FileReader(FILENAME);
        BufferedReader br = new BufferedReader(fr);
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] arrayString = line.split("(?=[,.])|\\s+");
                for (String temp : arrayString) {
                    if (temp.length() >= GetFiles.maxWord()) {
                        longestWord = temp;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return longestWord;
    }

    //reading from a file method
    static void readFile() throws IOException {
        FileReader fr = new FileReader(FILENAME);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    //write to a file
    public static void writeFile(String str) throws IOException {
        FileWriter fr = new FileWriter("newtext.txt");
        BufferedWriter bw = new BufferedWriter(fr);
        try {
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        int counter = 0;
        String keyword = "house";
        int maxWord = 0;
        HashSet<String> listWords = new HashSet<>();
        // reads from file
        GetFiles.readFile();

        try {
            //declares a br to  file oldtext
            br = new BufferedReader(new FileReader(FILENAME));
            while ((line = br.readLine()) != null) {
                GetFiles.writeFile(line); // writes to a file
                String[] arrayString = line.split("(?=[,.])|\\s+");
                for (int i = 0; i < arrayString.length; i++) {
                    if (GetFiles.maxWord() == arrayString[i].length()) {
                        listWords.add(arrayString[i]);
                    }
                    if (keyword.equals(arrayString[i].toLowerCase())) {
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        println("The word: '" + keyword + "' appeared in the file " + counter + " times!");
        println("The longest word is " + GetFiles.longestWord() + " and has " + GetFiles.maxWord() + " letters");
        println("There are " + listWords.size() + " unique words that have " + maxWord + " letters");
        println("And the longest words are: ");

        for (String temp : listWords) {
            println(temp);
        }


    }
}
