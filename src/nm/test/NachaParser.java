package nm.test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NachaParser {

    public static String[] getFiles(String textdate, String run) {
        String nachaFileDir = "/Users/nagars/Dev/nacha-macha/testfiles/";
        String nachaFileName = "ACHFile-{date}-{run}-{modifier}.txt";
        String filepattern = nachaFileName;
        filepattern = filepattern.replace("{date}", textdate);
        filepattern = filepattern.replace("{run}", run);
        filepattern = filepattern.replace("{modifier}", ".*?");
        final String pattern = filepattern;
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.matches(pattern);
            }
        };
        Set<String> fileset = Stream.of(new File(nachaFileDir).listFiles(filter))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
        System.out.println("Matching " + pattern + " " + fileset.size());
        List<String> files = new ArrayList<>(fileset);
        Collections.sort(files);
        return files.toArray(new String[files.size()]);
    }

}
