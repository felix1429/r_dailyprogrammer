//http://www.reddit.com/r/dailyprogrammer/comments/217klv/4242014_challenge_154_easy_march_madness_brackets/

import java.util.*;

public class MarchMadnessBrackets {
	
	public static Bracket makeBracket(Character type) {
		Bracket aBracket = new Bracket(type.toString());
		return aBracket;
	}
	
	public static void main(String[] args) {
		
		Stack<Bracket> bracketStack = new Stack<Bracket>();
		String wholeInput;
		String blockString;
		String finalString = "";
		Bracket bracketVar;
		Character iterVar;
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Input a string");

			wholeInput = sc.nextLine();
			char[] inputCharArray = wholeInput.toCharArray();
			List<Character> wholeList = new ArrayList<Character>();
			for(Character a : inputCharArray) {
				wholeList.add(a);
			}
			blockString = "";
			Iterator<Character> iter = wholeList.iterator();
			bracketStack.push(makeBracket(iter.next()));
			while(iter.hasNext()) {
				iterVar = iter.next();
				if(iterVar.equals('(') || iterVar.equals('{') || iterVar.equals('[')) {
					if(!(blockString.equals(""))) {
						bracketVar = makeBracket(iterVar);
						bracketVar.content = blockString.toString();
						bracketStack.push(bracketVar);
						blockString = "";
					}else {
						blockString = "";
					}	
				}else if(iterVar.equals(')') || iterVar.equals('}') || iterVar.equals(']')) {
					bracketVar = bracketStack.pop();
					finalString = bracketVar.content.concat((blockString.toString()));
					System.out.println(finalString);
					finalString = "";
				}else {
					blockString.concat(iterVar.toString());
				}
				
			}
		}finally {
			sc.close();
		}
	}
	
	static class Bracket {
		
		public String bracketType;
		public String content = "";
		
		public Bracket(String startBracketType) {
			this.bracketType = startBracketType;
			this.content = "";
		}
		
		public void addContent(String startContent) {
			this.content = startContent;
		}
		
		
	}
}