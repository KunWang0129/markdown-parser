//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

//nmsl

//add a line

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // checks whether all characters for links are in the text file
        if(!markdown.contains("[") 
        || !markdown.contains("]") 
        || !markdown.contains("(")
        || !markdown.contains(")")) { 
            return toReturn;
        }
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {

            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            //checks number of backticks in the brackets
            int index = openBracket;
            int tickNum = 0;
            while(index < markdown.length()){
                if(markdown.indexOf('`',index) == -1){
                    break;
                }
                else if(markdown.indexOf('`', index) > openBracket &&
                markdown.indexOf("`",index) < openParen){
                    tickNum++;
                }
                index = markdown.indexOf('`', index) + 1;
            }

            //makes sure loop doesnot check previous indices
            if(closeParen < currentIndex){
                break;
            }
            //makes sure the hyperlink is next to the url, making it a valid link
            if(!(closeBracket + 1 == openParen)) {  

            }
            //makes sure that this isn't an image reference
            else if((markdown.contains("!") 
            && (markdown.indexOf("!",currentIndex) == openBracket - 1))) {
            }
            else if(tickNum%2 == 0){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            currentIndex = closeParen+1;

        }
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
