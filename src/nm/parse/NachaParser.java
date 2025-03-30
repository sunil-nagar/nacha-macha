package nm.parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NachaParser {
    
    public static void main(String[] args) {
        String filePath = "/Users/nagars/Dev/nacha-macha/nacha-file-test-1.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                NachaFileLine nachaFileLine = NachaLineParser.parse(line);
                System.out.println(nachaFileLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
