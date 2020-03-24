package io.archive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Test {

    private static void zip(String sourceDir, String zipFile, String ext) throws Exception {
        // Cоздание объекта ZipOutputStream из FileOutputStream
        FileOutputStream fout = new FileOutputStream(zipFile);
        ZipOutputStream zout = new ZipOutputStream(fout);

        // Создание объекта File object архивируемой директории
        File fileSource = new File(sourceDir);

        addDirectory(zout, fileSource, ext);

        // Закрываем ZipOutputStream
        zout.close();

        System.out.println("Zip файл создан!");
    }

    private static void addDirectory(ZipOutputStream zout, File fileSource, String ext)
            throws Exception {
        File[] files = fileSource.listFiles();
        System.out.println("Добавление директории <" + fileSource.getName() + ">");
        for (int i = 0; i < files.length; i++) {
            // Если file является директорией, то рекурсивно вызываем
            // метод addDirectory
            if (files[i].isDirectory()) {
                addDirectory(zout, files[i], ext);
                continue;
            }
            if (files[i].getName().endsWith(ext)) {
                continue;
            }
            System.out.println("Добавление файла <" + files[i].getName() + ">");

            FileInputStream fis = new FileInputStream(files[i]);

            zout.putNextEntry(new ZipEntry(files[i].getPath()));

            byte[] buffer = new byte[4048];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zout.write(buffer, 0, length);
            }
            // Закрываем ZipOutputStream и InputStream
            zout.closeEntry();
            fis.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Args args1 = new Args(args);
        String source = args1.directory();
        String zipFile = args1.output();
        String except = args1.excuse();
        //   -d /home/sekator/test/ -e *.java -o project.zip
        zip(source, zipFile, except);

    }
}