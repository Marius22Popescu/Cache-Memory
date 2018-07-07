package Cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSource implements Source{
	public Object readData(String k) {
		Object ob = null;
		File file = new File("file1.txt");
		try {
			//Input the file
			Scanner scanner = new Scanner(file);
			String input = "";
			String text = "";
			String target = "";
			String []pair ;
			while(scanner.hasNextLine()) {
				scanner.useDelimiter("-");
				String key = scanner.next();
				String value = scanner.next();
				//scanner.nextLine();
				if (key.equals(k)) {
					return value;
				}				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return ob;
	}
} 
