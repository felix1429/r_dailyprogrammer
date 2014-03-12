//http://www.reddit.com/r/dailyprogrammer/comments/1ystvb/022414_challenge_149_easy_disemvoweler/cfvkt0n?context=3

import java.util.*;

public class Disemvoweler {
	
	public static void main(String[] args) {
		List<Character> vowelList = new ArrayList<Character>();
		vowelList.add('a');
		vowelList.add('e');
		vowelList.add('i');
		vowelList.add('o');
		vowelList.add('u');
		vowelList.add('y');
		Scanner sc = new Scanner(System.in);
		String devoweledString = "";
		String vowelsFromString = "";
		String input;
		
		try {
			System.out.println("Input a string to devowel");
			input = sc.nextLine();
			char[] inputArray = input.toCharArray();
			for(Character iterChar : inputArray) {
				if(vowelList.contains(iterChar)) {
					vowelsFromString += String.valueOf(iterChar);
				}else if(iterChar.equals(' ')) {
					continue;
				}else {
					devoweledString += String.valueOf(iterChar);
				}
			}
			System.out.println("Devoweled String: " + devoweledString + "\nRemoved Vowels: " + vowelsFromString);
		}finally {
			sc.close();
		}
	}
}
