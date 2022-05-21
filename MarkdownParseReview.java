//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class MarkdownParseReview {

    public static ArrayList<String> getLinks(Scanner myReader) {
        boolean next = true;
        String line = myReader.nextLine();
        ArrayList<String> result = new ArrayList<>();
        
        while ((line != "") && next) {
            int currentIndex = 0;
            while(currentIndex < line.length()) {
                int openBracket = line.indexOf("[", currentIndex);
                int closeBracket = line.indexOf("]", openBracket);
                
                int openParen = line.indexOf("(", closeBracket);
                int closeParen = line.indexOf(")", openParen);
                result.add(line.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            } 
            next = myReader.hasNext();
            if (!next) {
                break;
            }
            line = myReader.nextLine();
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        File file = new File(fileName);
        Scanner myReader = new Scanner(file);
        ArrayList<String> result = getLinks(myReader);
        
        for (int i =0; i < 2; i ++) {
            System.out.println(result.get(i));
        }
    }
}
