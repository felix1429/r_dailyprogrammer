//http://www.reddit.com/r/dailyprogrammer/comments/1rdtky/111113_challenge_142_easy_falling_sand/cfx9z44?context=3

import java.io.*;

public class FallingSand {
	
	public static void main(String[] args) throws IOException {
		
		Integer matrixSize = 0;
		BufferedReader reader = null;
		String line;
		char[][]gridArray;
		
		try {
			File file = new File("C://Users/******/workspace/FallingSand/sand.txt");
			reader = new BufferedReader(new FileReader(file));
			matrixSize = Integer.parseInt(reader.readLine());
			gridArray = new char[matrixSize][matrixSize];
			for(int counter = 0; counter < matrixSize; counter ++) {
				line = reader.readLine();
				for(int counter1 = 0; counter1 < matrixSize; counter1 ++) {
					gridArray[counter][counter1] = (char)line.charAt(counter1);
				}
				line = "";
			}
		}finally {
			reader.close();
		}
		for(int counter2 = 0; counter2 < matrixSize - 1; counter2 ++) {
			for(int counter3 = 0; counter3 < matrixSize; counter3 ++) {
				if(gridArray[counter2][counter3] == '.') {
					if(gridArray[counter2 + 1][counter3] == ' ') {
						gridArray[counter2 + 1][counter3] = '.';
						gridArray[counter2][counter3] = ' ';
					}
				}
			}
		}
		for(int row = 0; row < matrixSize; row ++) {
			line = "";
			for(int column = 0; column < matrixSize; column ++) {
				line += Character.toString(gridArray[row][column]);
			}
			System.out.println(line);
		}
	}
}
