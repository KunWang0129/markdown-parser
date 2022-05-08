import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

import org.junit.*;
public class MarkdownParseTest {

    String link1 = "https://ucsd.com";
    String link2 = "some-thing.html";


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


}
