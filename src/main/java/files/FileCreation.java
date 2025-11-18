package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileCreation {
    public static void main(String[] args) {
        List<String> list1 = List.of("Hello", "my", "name", "is", "Alina");
        List<String> newList = new ArrayList<>();
        Path path1 = Paths.get("temp1.txt");
        if (!Files.exists(path1)) {
            try {
                Files.createFile(path1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Files.write(path1, list1, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String str : list1) {
            newList.add(str + String.valueOf(newList.indexOf(str)));
        }
        Path path2 = Paths.get("temp2.txt");

        try {
            Files.write(path2, newList, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
