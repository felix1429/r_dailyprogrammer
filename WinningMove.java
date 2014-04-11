//http://www.reddit.com/r/dailyprogrammer/comments/22fgs1/472014_challenge_157_easy_the_winning_move_xgames/cgpns1b

import java.util.*;
import java.io.*;

public class WinningMove {

	private static BufferedReader br = null; 
	private static String line;
	private static char player;
	private static char other;
	private static char[][] board;
	private static int tempRow;
	private static int tempColumn;
	private static ArrayList<Character> lineList = new ArrayList<Character>();
	private static int nullCount = 0;
	
	private static void print() {
		for(int row = 1;row < 4;row ++) {
			for(int column = 0;column < 3;column ++) {
				System.out.print(board[row][column]);
			}
			System.out.print("\n");
		}
		System.exit(0);
	}
	
	public static void main(String[] args) throws IOException {
		
		try {
			File file = new File("C://Users/Hennig/workspace/winningmove/input.txt"); //parses input
			br = new BufferedReader(new FileReader(file));
			board = new char[4][3];
			player = br.readLine().charAt(0);
			if((int)player == 88) {
				other = 'O';
			}else {
				other = 'X';
			}
			for(int counter = 1;counter < 4;counter ++) {
				line = br.readLine();
				for(int count = 0;count < 3;count ++) {
					board[counter][count] = (char)line.charAt(count);
				}
			}
			
			for(int column = 0;column < 3;column ++) { //checks columns
				for(int row = 1;row < 4;row ++) {
					if(board[row][column] == '-') {
						tempRow = row;
						tempColumn = column;
						nullCount ++;
					}
					lineList.add(board[row][column]);
				}
				if(nullCount == 1 && !lineList.contains(other)) {
					board[tempRow][tempColumn] = player;
					print();
				}
				nullCount = 0;
				lineList.clear();
			}
			
			for(int row = 1;row < 4;row ++) { //checks rows
				for(int column = 0;column < 3;column ++) {
					if(board[row][column] == '-') {
						tempRow = row;
						tempColumn = column;
						nullCount ++;
					}
					lineList.add(board[row][column]);
				}
				if(nullCount == 1 && !lineList.contains(other)) {
					board[tempRow][tempColumn] = player;
					print();
				}
				nullCount = 0;
				lineList.clear();
			}
			
			for(int count = 0;count < 3;count ++) { //checks r to l diagonal
				if(board[count + 1][count] == '-') {
					tempRow = count + 1;
					tempColumn = count;
					nullCount ++;
				}
				lineList.add(board[count + 1][count]);
			}
			if(nullCount == 1 && !lineList.contains(other)) {
				System.out.println(tempRow);
				System.out.println(tempColumn);
				board[tempRow][tempColumn] = player;
				print();
			}
			nullCount = 0;
			lineList.clear();
			
			lineList.add(board[1][2]); //checks l to r diagonal
			lineList.add(board[2][1]);
			lineList.add(board[3][0]);
			int row = 1;
			int column = 2;
			for(char derp : lineList) {
				if(derp == '-') {
					tempRow = row;
					tempColumn = column;
					nullCount ++;
				}
				row ++;
				column --;
			}
			if(nullCount == 1 && !lineList.contains(other)) {
				board[tempRow][tempColumn] = player;
				print();
			}
		
			
			System.out.println("No winning moves!"); //if no winning moves
		}finally {
			br.close();
		}
	}	
}