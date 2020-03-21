package io.file;

import java.io.File;
import java.util.Objects;

/**
 * if (!file.exists())  -  Проверяем, что файл существует
 * <p>
 * if (!file.isDirectory()) - Проверяет, что файл - это директория.
 * <p>
 * for (File subfile : file.listFiles()) - Получаем список файлов в этой директории.
 * <p>
 * if (subfile.isFile()) - возвращает значение true, если по указанному пути находится файл
 */
public class Dir {
    public static void main(String[] args) {
        File file = new File(".");
        if (!file.exists()) {
            throw new IllegalStateException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalStateException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
//        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : Objects.requireNonNull(file.listFiles())) {
//            System.out.println(subfile.getAbsoluteFile());
            if (subfile.isFile()) {
                System.out.printf("File name %s, size = %s \n", subfile.getName(), subfile.length());
            }
        }
    }
}