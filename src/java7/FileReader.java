package java7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.List;
import java.util.Set;

/**
 * Created by davlet on 6/16/17.
 */
public class FileReader {
    //file reader with new IO
    public static void main(String[] args) {
        Path firstPath = Paths.get("/Users/davlatbek/IdeaProjects/JavaCourse/file.txt");
        Path secondPath = Paths.get("/Users/davlatbek/IdeaProjects/JavaCourse/file2.txt");
        Set<PosixFilePermission> filePermissions =
                PosixFilePermissions.fromString("rw-rw-rw-");
        FileAttribute<Set<PosixFilePermission>> myFileAttribute =
                PosixFilePermissions.asFileAttribute(filePermissions);
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(firstPath,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.WRITE
            );
            bufferedWriter.write("new line");
            bufferedWriter.flush();
            bufferedWriter.close();
//            Path path2 = Files.createFile(secondPath, myFileAttribute);
            List<String> readLines = Files.readAllLines(firstPath);
            System.out.println(readLines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
