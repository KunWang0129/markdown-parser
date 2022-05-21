import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;


import org.junit.*;
public class MarkdownParseTest {

    String link1 = "https://ucsd.com";
    String link2 = "some-thing.html";

    final String Snippet1Link1 = "`google.com";
    final String Snippet1Link2 = "google.com";
    final String Snippet1Link3 = "ucsd.edu";

    final String Snippet2Link1 = "a.com";
    final String Snippet2Link2 = "a.com(())";
    final String Snippet2Link3 = "example.com";

    final String Snippet3Link1 = "https://www.twitter.com";
    final String Snippet3Link2 = "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule";
    final String Snippet3Link3 = "https://cse.ucsd.edu/";

    @Test
    public void addition() {
        assertEquals(2,1+1);
    }

    @Test
    public void TestFile1() throws IOException {
        Path fileName = Path.of("TestFile1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add("something.com");
        assertEquals(result, links);
    }

    @Test
    public void TestFile2() throws IOException {
        Path file2Path = Path.of("TestFile2.md");
        String file2Content = Files.readString(file2Path);
        ArrayList<String> links = MarkdownParse.getLinks(file2Content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(link1);
        result.add(link2);
        assertEquals(result, links);
    }

    @Test
    public void TestFile3() throws IOException {
        Path file3Path = Path.of("TestFile3.md");
        String file3Content = Files.readString(file3Path);
        ArrayList<String> links = MarkdownParse.getLinks(file3Content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(link2);
        assertEquals(result, links);
    }

    @Test
    public void MDPTestSnippet1() throws IOException{
        Path snippet1Path = Path.of("TestSnippet1.md");
        String snippet1Content = Files.readString(snippet1Path);
        ArrayList<String> links = MarkdownParse.getLinks(snippet1Content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(Snippet1Link1);
        result.add(Snippet1Link2);
        result.add(Snippet1Link3);
        assertEquals(result, links);
    }

    @Test
    public void MDPTestSnippet2() throws IOException{
        Path snippet2Path = Path.of("TestSnippet2.md");
        String snippet2Content = Files.readString(snippet2Path);
        ArrayList<String> links = MarkdownParse.getLinks(snippet2Content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(Snippet2Link1);
        result.add(Snippet2Link2);
        result.add(Snippet2Link3);
        assertEquals(result, links);
    }

    @Test
    public void MDPTestSnippet3() throws IOException{
        Path snippet3Path = Path.of("TestSnippet3.md");
        String snippet3Content = Files.readString(snippet3Path);
        ArrayList<String> links = MarkdownParse.getLinks(snippet3Content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(Snippet3Link1);
        result.add(Snippet3Link2);
        result.add(Snippet3Link3);
        assertEquals(result, links);
    }

    @Test
    public void MDPRTestSnippet1() throws IOException{
        File file = new File("TestSnippet1.md");
        Scanner s = new Scanner(file);
        ArrayList<String> links = MarkdownParseReview.getLinks(s);
        ArrayList<String> result = new ArrayList<String>();
        result.add(Snippet1Link1);
        result.add(Snippet1Link2);
        result.add(Snippet1Link3);
        assertEquals(result, links);
    }

    @Test
    public void MDPRTestSnippet2() throws IOException{
        File file = new File("TestSnippet2.md");
        Scanner s = new Scanner(file);
        ArrayList<String> links = MarkdownParseReview.getLinks(s);
        ArrayList<String> result = new ArrayList<String>();
        result.add(Snippet2Link1);
        result.add(Snippet2Link2);
        result.add(Snippet2Link3);
        assertEquals(result, links);
    }

    @Test
    public void MDPRTestSnippet3() throws IOException{
        File file = new File("TestSnippet3.md");
        Scanner s = new Scanner(file);
        ArrayList<String> links = MarkdownParseReview.getLinks(s);
        ArrayList<String> result = new ArrayList<String>();
        result.add(Snippet3Link1);
        result.add(Snippet3Link2);
        result.add(Snippet3Link3);
        assertEquals(result, links);
    }


}
