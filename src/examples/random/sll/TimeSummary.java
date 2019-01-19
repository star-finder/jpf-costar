package random.sll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class TimeSummary {
	
	public static void main(String[] args) throws Exception {
		File folder = new File("./expected-output/random/time");
		
		File[] files = folder.listFiles();
		Arrays.sort(files);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (File file : files) {			
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = br.readLine();
			
			String methodName = "";
			
			while (s != null) {
				if (s.contains(".jpf")) {
					int start = s.indexOf("_") + 1;
					int end = s.indexOf(".");
					
					methodName = s.substring(start, end);
					
					if (!map.containsKey(methodName))
						map.put(methodName, 0);
				} else if (s.contains("Time = ")) {
					int start = s.indexOf("=") + 2;
					int end = s.length();
					
					int time = Integer.parseInt(s.substring(start, end));
					int oldTime = map.get(methodName);
					
					map.put(methodName, oldTime + time);
				}
				
				s = br.readLine();
			}
		}
		
		ArrayList<String> allMethodNames = new ArrayList<String>(map.keySet());
		Collections.sort(allMethodNames);
		
		for (String methodName : allMethodNames) {
//			System.out.println("method = " + methodName);
			System.out.println(map.get(methodName));
		}
	}

}
