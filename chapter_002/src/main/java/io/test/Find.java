//package io.test;
//
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Main class that starts the application using command line arguments.
// */
//public class Find {
//    /**
//     * @param args used arguments: [-d directory] -n name [-m | -f | -r] [-o output]
//     *             <p>
//     *             -d directory    directory where the search starts
//     *             -n name         name of the file or pattern for other types of search
//     *             -m              search by mask
//     *             -f              search by full name
//     *             -r              search by regular expression
//     *             -o output       name of the result file
//     *             <p>
//     *             default starting directory is the current directory
//     *             default search is by full name
//     *             default result file is 'log.txt'
//     */
//    public static void main(String[] args) {
//        Args arguments;
//        try {
//            arguments = new Args(args);
//        } catch (IllegalArgumentException e) {
//            displayInfo();
//            return;
//        }
//        try {
//            List<String> result = findFiles(arguments.getRoot(), arguments.getName(), arguments.getSearchBy());
//            writeResult(result, arguments.getOutput());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Finds files in the specified directory.
//     *
//     * @param dir  starting directory
//     * @param name name of the file or pattern for other types of search
//     * @param type type of search
//     * @return list of found files
//     * @throws IOException if an I/O error occurs
//     */
//    private static List<String> findFiles(Path dir, String name, SearchBy type) throws IOException {
//        FindService findService = new FindService(dir, Integer.MAX_VALUE);
//        List<Path> paths = findService.find(name, type);
//        List<String> lines = new ArrayList<>();
//        paths.forEach(p -> lines.add(p.toString()));
//        return lines;
//    }
//
//    private static void writeResult(List<String> lines, String output) throws IOException {
//        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(output))) {
//            for (String line : lines
//            ) {
//                writer.write(line);
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @SuppressWarnings("checkstyle:NoWhitespaceBefore")
//    private static void displayInfo() {
//        final String usage = String.join(System.lineSeparator(),
//                "Usage: java -jar find.jar [-d directory] -n name [-m | -f | -r] [-o output]" ,
//                "" ,
//                "-d directory    directory where the search starts" ,
//                "-n name         name of the file or pattern for other types of search" ,
//                "-m              search by mask" ,
//                "-f              search by full name" ,
//                "-r              search by regular expression" ,
//                "-o output       name of the result file" ,
//                "" ,
//                "default starting directory is the current directory" ,
//                "default search is by full name" ,
//                "default result file is 'logout.txt'");
//        System.out.println(usage);
//    }
//}
