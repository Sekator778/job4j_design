package gc;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CacheTest {

    @Ignore
    public void whenReadSimpleNameTXT() {
        String expected = "Nick" + System.lineSeparator() + "Masha" + System.lineSeparator() + "Victor";
        String name = "name.txt";
        File file = new File("/home/sekator/projects/job4j_design/chapter_005/src/main/resources/name.txt");
        String absolutePath = file.getAbsolutePath();
        String tempFilePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
        Cache cacheFileData = new Cache(tempFilePath);
        assertThat(cacheFileData.getValue(name), is(expected));
    }

    @Ignore
    public void whenReadSimpleAddressTXT() {
        String expected = "Dom" + System.lineSeparator() + "Pyshkina" + System.lineSeparator() + "Ylitsa";
        String name = "address.txt";
        File file = new File("/home/sekator/projects/job4j_design/chapter_005/src/main/resources/address.txt");
        String absolutePath = file.getAbsolutePath();
        String tempFilePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
        Cache cacheFileData = new Cache(tempFilePath);
        assertThat(cacheFileData.getValue(name), is(expected));
    }

    @Test
    public void whenReadOneWhenLoadFromFile() throws IOException {
        // строка ожидаемая с разделителями
        String expected = "Alex" + System.lineSeparator() + "Kolya" + System.lineSeparator() + "Dilon";
        // делаем тмп файл
        File file = File.createTempFile("temp", ".txt");
        //записываем в него строку ожидаемую
//        System.out.println(" temp file "  + file);
        Files.write(file.toPath(), expected.getBytes());
        // берем имя файла тмп
        String name = file.getName();
        // берем абсолютный путь
        String absolutePath = file.getAbsolutePath();
        // берем путь относительный
        String tempFilePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
        // создаем кеш на основе нашего тмп файла
        Cache cacheFileData = new Cache(tempFilePath);
        // читаем все что в нем есть и сравниваем со строкой начальной
        assertThat(cacheFileData.getValue(name), is(expected));
    }

    @Test
    public void whenReadSecondTimeWhenGetFromCache() throws IOException {
        String expected = "John" + System.lineSeparator() + "Bob" + System.lineSeparator() + "Alex";
        File file = File.createTempFile("temp", ".txt");
        Files.write(file.toPath(), expected.getBytes());
        String name = file.getName();
        String absolutePath = file.getAbsolutePath();
        String tempFilePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
        Cache cacheFileData = new Cache(tempFilePath);
        assertThat(cacheFileData.getValue(name), is(expected));
        // до этого делаем все тоже но тут  делаем его в 0 и записываем в файл JAVA
        Files.write(file.toPath(), "JAVA".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        assertThat(cacheFileData.getValue(name), is(expected));
        assertThat(Files.readString(file.toPath()), is("JAVA"));
    }

}