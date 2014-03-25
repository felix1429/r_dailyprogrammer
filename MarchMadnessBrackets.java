//http://www.reddit.com/r/dailyprogrammer/comments/217klv/4242014_challenge_154_easy_march_madness_brackets/

import java.util.*;

public class MarchMadnessBrackets {
	
	public static void main(String[] args) {
		
		ArrayList<Bracket> bracketList = new ArrayList<Bracket>();
		String wholeInput;
		Scanner sc = new Scanner(System.in);
		String scanInput;
		
		System.out.println("Input a string");
		wholeInput = sc.nextLine();
		char[] inputCharArray = wholeInput.toCharArray();
		int counter = 0;
		for(Character chr : inputCharArray) {
			if(chr.equals('(') || chr.equals('{') || chr.equals('[')) {
				Bracket aBracket = new Bracket(chr.toString(), "");
				bracketList.add(aBracket);
			}
		}
	}
	
	static class Bracket {
		
		public String bracketType;
		public String content = "";
		
		public Bracket(String startBracketType, String startContent) {
			this.bracketType = startBracketType;
			this.content = startContent;
		}
		
		
	}
}
