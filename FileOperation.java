import java.io.*;
import java.nio.file.*;

public class FileOperation {

    public static void main(String[] args) {

        String fileName = "sample.txt";

        try {
            
            FileWriter writer = new FileWriter(fileName);

            writer.write("Hello, World!\n");
            writer.write("Welcome to Java File Handling.\n");
            writer.write("This is the original file.\n");

            writer.close();
            System.out.println("File created and data written successfully.\n");

           
            System.out.println("Reading File:");
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

            
            Path path = Paths.get(fileName);

            String content = Files.readString(path);
            content = content.replace("original", "modified");

            Files.writeString(path, content);

            System.out.println("\nFile modified successfully.\n");

            
            System.out.println("Reading Modified File:");

            reader = new BufferedReader(new FileReader(fileName));

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
