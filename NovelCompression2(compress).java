import java.io.*;
import java.util.*;

public class NovelCompression2 {

	public static BufferedReader reader = null;
	public static BufferedWriter writer = null;
	public static String output = "";
	public static String dictionaryList = "";
	public static StringTokenizer st = null;
	public static List<String> dictionary = new ArrayList<String>();
	public static char[] stringArray;
	public static String temp;
	public static Map<String, Integer>indexMap = new HashMap<String, Integer>();
	public static String blah;
	public static Integer count = 0;
	
	public static void main(String[] args) throws IOException {
		
		try {
			File file = new File("C://Users/Hennig/workspace/NovelCompression2/2input.txt");
			File oFile = new File("C://Users/Hennig/workspace/NovelCompression2/2output.txt");
			writer = new BufferedWriter(new FileWriter(oFile));
			reader = new BufferedReader(new FileReader(file));
			
			while((blah = reader.readLine()) != null) {
				if(count != 0) {
					output += ("R \r\n");
				}
				st = new StringTokenizer(blah);
				while(st.hasMoreTokens()) {
					temp = st.nextToken();
					if(isSymbol(temp)) {
						output += (temp + " ");
					}else {
						if(!(dictionary.contains(stripCrap(temp)))) {
							dictionary.add(stripCrap(temp));
							indexMap.put(stripCrap(temp), (dictionary.size() - 1));
						}
						if(!(isSymbol(temp.substring(temp.length() - 1)))) {
							if(Character.isUpperCase(temp.charAt(0))) {
								output += (indexMap.get(stripCrap(temp)) + "^ ");
							}else {
								output += (indexMap.get(stripCrap(temp)) + " ");
							}	
						}else {
							if(Character.isUpperCase(temp.charAt(0))) {
								output += (indexMap.get(stripCrap(temp)) + "^ " + (temp.substring(temp.length() - 1)) + " ");
							}else {
								output += (indexMap.get(stripCrap(temp)) + " " + (temp.substring(temp.length() - 1)) + " ");
							}	
						}
					}
				}
				count ++;
			}
			output += ("E");
			dictionaryList += (dictionary.size() + "\r\n");
			for(String wut : dictionary) {
				dictionaryList += (wut + "\r\n");
			}
			writer.write(dictionaryList);
			writer.write(output);
		}finally {
			reader.close();
			writer.close();
		}
	}
	
	public static Boolean isSymbol(String input) {
		if(input.equals(".") || input.equals(",") || input.equals("?") || input.equals("!") || input.equals(";") || input.equals(":")) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static String stripCrap(String start) {
		
		stringArray = start.toCharArray();
		String iterString;
		String finalString = "";
		
		for(char iter : stringArray) {
			iterString = Character.toString(iter);
			if(Character.isLetter(iter)) {
				iterString = iterString.toLowerCase();
				finalString += iterString;
			}	
		}
		return finalString;
	}
}
