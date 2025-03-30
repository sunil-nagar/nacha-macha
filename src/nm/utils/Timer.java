package nm.utils;

import java.util.Calendar;
import java.util.HashMap;

public class Timer {

	private static HashMap<String, Long> data = new HashMap<String, Long>();
	
	public static void start(String name) {
		data.put(name, Calendar.getInstance().getTimeInMillis());
	}

	public static void stop(String name) {
		long stop = Calendar.getInstance().getTimeInMillis();
		long start = data.get(name);
		data.put(name, stop - start);
		System.out.println(report(name));
	}
	
	public static String report(String name) {
		return "Time for " + name + "\t\t" + data.get(name);
	}

}

