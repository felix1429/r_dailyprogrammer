//http://www.reddit.com/r/dailyprogrammer/comments/25clki/5122014_challenge_162_easy_novel_compression_pt_1/chhioum

import java.io.*;
import java.util.*;

public class NovelCompression1 {

	public static String temp = "";
	public static String blah = "";
	public static String moarTemp = "";
	public static Integer dictionarySize;
	public static BufferedReader reader = null;
	public static BufferedWriter writer = null;
	public static String output = "";
	public static Integer counter = 0;
	public static Map<Double, String> dictionary = new HashMap<Double, String>();
	public static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		
		try {
			File file = new File("C://Users/Hennig/workspace/NovelCompression1/1input.txt");
			File oFile = new File("C://Users/Hennig/workspace/NovelCompression1/1output.txt");
			reader = new BufferedReader(new FileReader(file));
			writer = new BufferedWriter(new FileWriter(oFile));
			dictionarySize = Integer.parseInt(reader.readLine());
			for(double count = 0.0;count <= dictionarySize - 1;count ++) {
				temp = reader.readLine();
				dictionary.put(count, temp);
			}
			
			while((blah = reader.readLine()) != null) {
				st = new StringTokenizer(blah);
				while(st.hasMoreTokens()) {
					temp = st.nextToken();
					if(temp.equals(".") || temp.equals(",") || temp.equals("?") || temp.equals("!") || temp.equals(";") || temp.equals(":") || temp.equals("-")) {
						output += (temp);
					}else {
						if(counter != 0) {
							output += (" ");
						}	
						if(isNumeric(temp) && dictionary.containsKey(Double.valueOf(temp))) { //if is just number
							output += (dictionary.get(Double.valueOf(temp)));
						}else if(temp.substring((temp.length() - 1)).equals("^")) { //if has carat
							moarTemp = dictionary.get(Double.valueOf(temp.substring(0, temp.length() - 1))); //gets dic entry
							output += (Character.toUpperCase(moarTemp.charAt(0)) + moarTemp.substring(1));
						}else if(temp.substring((temp.length() - 1)).equals("!")) { //if has exclamation point
							moarTemp = dictionary.get(Double.valueOf((temp.substring(0, temp.length() - 1)))); //gets dic entry
							output += (moarTemp.toUpperCase());
						}
						
						counter ++;
						if (temp.equals("r") || temp.equals("R")) {
							output += ("\r\n");
							counter = 0;
						}else if (temp.equals("e") || temp.equals("E")) {
							break;
						}
						
					}
				}
			}
			writer.write(output);
		}finally {
			reader.close();
			writer.close();
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