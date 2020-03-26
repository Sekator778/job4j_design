package myio;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.stream.Stream;

public class Channeks {
    public static void main(String[] args) {
//        int i;
//        Path path = Path.of("result.txt");
//        Path pathTo = Path.of("/home/sekator/testDir/output2.txt");
//        File files = path.toFile();
//        System.out.println(Files.isRegularFile(path));
//        try (InputStream fis = Files.newInputStream(path)) {
//            do {
//                i = fis.read();
//                if (i != -1) {
//                    System.out.print((char) fis.read());
//
//                }
//            } while (i != -1);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Files.copy(path, pathTo, StandardCopyOption.REPLACE_EXISTING);
//        try(OutputStream fos = new BufferedOutputStream(Files.newOutputStream(pathTo))) {
//            for (int j = 0; j < 26; j++) {
//                fos.write((byte) ('A' + j));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String dirName = ("/home/sekator");
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(dirName))) {
            System.out.println("Directory " + dirName);
            for (Path entry : dirStream
            ) {
                BasicFileAttributes attributes = Files.readAttributes(
                        entry, BasicFileAttributes.class
                );
                if (attributes.isDirectory()) {
                    System.out.print("<DIR> ");
                } else {
                    System.out.print("           ");
                }
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
