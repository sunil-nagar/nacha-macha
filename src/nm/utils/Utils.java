package nm.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Utils {

	public static String pad(String s, int len) {
		if (s == null)
			s = "";
		while (s.length() < len) // low performance
			s = s + " ";
		return s;
	}

	public static void emptyException(String property, int value) throws Exception {
		if (value <= 0)
			throw new Exception(property + " must be greater than zero");
	}

	public static void emptyException(String property, String value) throws Exception {
		if (value == null || value.trim().length() == 0)
			throw new Exception(property + " is empty");
	}

	public static String getAbsolutePath(String filename) {
		File f = new File(filename);
		String path = f.getAbsolutePath();
		return path;
	}

	public static String getFilename(String filename) {
		File f = new File(filename);
		String name = f.getName();
		return name;
	}

	public static Set<String> listFiles(String dir) {
		return Stream.of(new File(dir).listFiles()).filter(file -> !file.isDirectory()).map(File::getName)
				.collect(Collectors.toSet());
	}

	public static String readFile(String f) throws IOException {
		Path path = Paths.get(f);
		byte[] buffer = java.nio.file.Files.readAllBytes(path);
		return new String(buffer);
	}

	public static void writeFile(String f, String data) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(f);
		outputStream.write(data.getBytes());
		outputStream.close();
	}

	public static String toInitLowerCaseString(String s) {
		if (s == null)
			return "";
		if (s.length() == 0) {
			return s;
		}
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	public static String filename16(String s) {
		if (s == null)
			s = "";
		s = s.trim();
		s = s.replace("  ", "");
		s = s.replace(" ", "");
		s = s.replaceAll("[^-a-zA-Z0-9]", "");
		if (s.length() > 16)
			s = s.substring(0, 16);
		s = s.toLowerCase();
		return s;
	}

}
