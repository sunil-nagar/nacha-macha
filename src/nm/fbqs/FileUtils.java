package nm.fbqs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    public static String[] listFiles(String dir) {
        System.out.println("FileUtils.listFiles " + dir);
        Set<String> fileset = Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
        List<String> files = new ArrayList<>(fileset);
        for (int i = 0; i < files.size(); i++) {
            files.set(i, dir + "/" + files.get(i));
        }
        Collections.sort(files);
        return files.toArray(new String[files.size()]);
    }

    public static void moveFiles(String source, String dest) throws IOException {
        File srcdir = new File(source);
        File[] files = srcdir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Path sourcePath = Paths.get(file.getPath());
                    Path destinationPath = Paths.get(dest, file.getName());
                    Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }

    public static void moveFile(String source, String dest) throws IOException {
        System.out.println("FileUtils.moveFile " + source + " " + dest);
        Files.move(Paths.get(source), Paths.get(dest, new File(source).getName()), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyFiles(String source, String dest) throws IOException {
        System.out.println("FileUtils.copyFiles " + source + " " + dest);
        String[] files = listFiles(source);
        for (int i = 0; i < files.length; i++) {
            File sourceFile = new File(files[i]);
            File destFile = new File(dest + sourceFile.getName());
            copyFile(sourceFile, destFile);
        }
    }

    public static void copyFile(File source, File dest) throws IOException {
        System.out.println("FileUtils.copyFile " + source + " " + dest);
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

}
