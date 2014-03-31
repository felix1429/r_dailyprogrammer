//http://www.reddit.com/r/dailyprogrammer/comments/1pwl73/11413_challenge_139_easy_pangrams/cgg7zjc

import java.util.*;

public class Pangrams {
	
	public static void main(String[] args) {
		
		char[] input;
		Scanner sc = new Scanner(System.in);
		Integer temp;
		List<Integer> asciiList = new ArrayList<Integer>();
		List<Integer> inputList = new ArrayList<Integer>();
		for(int count = 97;count < 123;count ++) {
			asciiList.add(count);
		}
		Collections.sort(asciiList);
		
		try {
			System.out.println("Input a string");
			input = sc.nextLine().toLowerCase().toCharArray();
			for(Character chr : input) {
				temp = (int) chr;
				if(temp.equals(32)) {
					continue;
				}else if(!inputList.contains(temp)) {
					inputList.add(temp);
				}
			}
			Collections.sort(inputList);
			if(inputList.equals(asciiList)) {
				System.out.println("true");
			}else {
				System.out.println("false");
			}
		}finally {
			sc.close();
		}
	}
}
