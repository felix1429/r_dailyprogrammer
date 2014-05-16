//http://www.reddit.com/r/dailyprogrammer/comments/25clki/5122014_challenge_162_easy_novel_compression_pt_1/chhioum

import java.io.*;
import java.util.*;

public class NovelCompression1 {

	private static String temp = "";
	private static String moarTemp = "";
	private static Integer dictionarySize;
	private static BufferedReader reader = null;
	private static Map<Double, String> dictionary = new HashMap<Double, String>();
	private static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		
		try {
			File file = new File("C://Users/Hennig/workspace/NovelCompression1/input.txt");
			reader = new BufferedReader(new FileReader(file));
			dictionarySize = Integer.parseInt(reader.readLine());
			for(double count = 0.0;count <= dictionarySize;count ++) {
				temp = reader.readLine();
				dictionary.put(count, temp);
			}
			
			st = new StringTokenizer(reader.readLine());
			while(st.hasMoreTokens()) {
				temp = st.nextToken();
				if(isNumeric(temp) && dictionary.containsKey(Double.valueOf(temp))) { //if is just number
					System.out.print(" " + dictionary.get(Double.valueOf(temp)));
				}else if(temp.equals(".") || temp.equals(",") || temp.equals("?") || temp.equals("!") || temp.equals(";") || temp.equals(":") || temp.equals("-")) {
					System.out.print(temp);
				}else if(temp.substring((temp.length() - 1)).equals("^")) { //if has carat
					moarTemp = dictionary.get(Double.valueOf(temp.substring(0, temp.length() - 1))); //gets dic entry
					System.out.print(" " + Character.toUpperCase(moarTemp.charAt(0)) + moarTemp.substring(1));
				}else if(temp.substring((temp.length() - 1)).equals("!")) { //if has exclamation point
					moarTemp = dictionary.get(Double.valueOf((temp.substring(0, temp.length() - 1)))); //gets dic entry
					System.out.print(" " + moarTemp.toUpperCase());
				
				}else if (temp.equals("r") || temp.equals("R")) {
					System.out.println("");
				}else if (temp.equals("e") || temp.equals("E")) {
					System.exit(0);
				}
			}
		}finally {
			reader.close();
		}
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}
