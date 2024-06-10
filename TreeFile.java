import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TreeFile {
    public void export_(String input){
        try (PrintWriter out = new PrintWriter(new FileWriter("Files\\output.txt"))) {
            out.println(input);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public String import_()throws IOException {
        StringBuilder fileContents = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("Files\\output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContents.append(line);
                fileContents.append(System.lineSeparator());
            }
        }
        return fileContents.toString();
    }
}
