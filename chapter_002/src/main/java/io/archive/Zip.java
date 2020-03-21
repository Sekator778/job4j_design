package io.archive;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private List<File> seekBy(String root, String ext) throws IOException {
        MyVisitorForArchive myVisitorForArchive = new MyVisitorForArchive();
        myVisitorForArchive.setPartOfName(ext);
        Files.walkFileTree(Paths.get(root), myVisitorForArchive);
        return myVisitorForArchive.getFoundFiles();
    }

    public static void pack(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Args args1 = new Args(args);
        new Zip().seekBy(args1.directory(), args1.excuse())
                .forEach(file ->
                        pack(file, args1.output()));
    }
}
