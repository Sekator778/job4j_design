package io.archive;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Задана директория проекта, например: c:\project\job4j\
 * 2. В качестве ключа передается  расширения файлов, которые не нужно включать в архив.
 * 3. Архив должен сохранять структуру проекта.
 * 4. Запуск проекта java -jar pack.jar -d c:\project\job4j\ -e *.java -o project.zip
 * <p>
 * java -jar pack.jar - Это собранный jar.
 * <p>
 * -d - directory - которую мы хотим архивировать
 * -e - exclude - исключить файлы *.xml
 * -o - output - во что мы архивируем.
 */
public class Zip {
    /**
     * https://mkyong.com/java/java-files-walk-examples/
     * walk  - это гулять вот он нам и по нашему пути делает стрим какой
     * нам надо
     *
     * @param root где гулять директория
     * @param ext  - чего исключать по строке в имени
     * @return - лист файлов которые проходят
     */
    private List<File> seekBy(String root, String ext) {
        List<File> list = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(root))) {
            walk
                    .filter(Files::isRegularFile)
                    .filter(path -> !path.getFileName().toString().endsWith(ext))
                    .forEach(i -> list.add(i.toFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param source - лист файлов для подальшей архивации
     * @param output - path zip output file
     */
    public static void pack(List<File> source, String output) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(output)))) {
            for (File file : source
            ) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Args args1 = new Args(args);
        pack(new Zip().seekBy(args1.directory(), args1.excuse()), args1.output());
    }
}
