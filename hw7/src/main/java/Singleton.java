
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Singleton {
    private static Singleton single_instance = null;
    public File writer;
    private Singleton() throws IOException {

            this.writer = new File("log.txt");
            if(!writer.exists()){
                writer.createNewFile();
            }

    }
    public void writeToFile(String string) throws IOException {

        Files.writeString(Paths.get(String.valueOf(this.writer)), string + "\n", StandardOpenOption.APPEND);

    }

    public static Singleton getInstance() throws IOException {
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }
}