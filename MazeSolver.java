import java.io.*;

public class MazeSolver {

	public static BufferedReader reader = null;
	public String blah;
	int foo = 0;
	static int sX;
	static int sY;
	static int eX;
	static int eY;
	public static MazeSolver derp;

	public static Direction direction = Direction.RIGHT;
	public static char[][]mazeArray;
	public static char[]lineArray;
	public static File file = new File("D:/Workspace/MazeSolver/maze.txt");

	
	public static void main(String[] args) throws IOException {
	
		int xCoord;
		int yCoord;
		
		try {
			 
			 reader = new BufferedReader(new FileReader(file));
			 mazeArray = fileToArray();
			 xCoord = sX;
			 yCoord = sY;
			 for(int wub = 0;wub < 250;wub ++) {
				 System.out.println(direction);
				 if(direction.equals(Direction.UP)) {
					if(mazeArray[xCoord][yCoord + 1] == 'E') {
						yCoord = add(yCoord);
					}else if((mazeArray[xCoord][yCoord + 1] == '#')) { //checks variable to right
						if((mazeArray[xCoord - 1][yCoord] == ' ') || (mazeArray[xCoord - 1][yCoord] == '*')) { //checks variable up ahead
							mazeArray[xCoord][yCoord] = '*';
							xCoord = sub(xCoord);
						}else if(mazeArray[xCoord - 1][yCoord] == '#') {
							mazeArray[xCoord][yCoord] = '*';
							yCoord = sub(yCoord);
							direction = changeDirection(Direction.LEFT);
						}else if(mazeArray[xCoord - 1][yCoord] == '#') {
							direction = changeDirection(Direction.DOWN);
						}
					}else if((mazeArray[xCoord][yCoord + 1] == ' ') || (mazeArray[xCoord][yCoord + 1] == '*') || (mazeArray[xCoord][yCoord + 1] == 'E')) {
						mazeArray[xCoord][yCoord] = '*';
						yCoord = add(yCoord);
						direction = changeDirection(Direction.RIGHT);
					}
				 }else if(direction.equals(Direction.DOWN)) {
					if(mazeArray[xCoord][yCoord - 1] == 'E') {
						yCoord = sub(yCoord);
					}else if((mazeArray[xCoord][yCoord - 1] == '#')) {
						if(mazeArray[xCoord + 1][yCoord] == '#') {
							mazeArray[xCoord][yCoord] = '*';
							direction = changeDirection(Direction.UP);
						}else if((mazeArray[xCoord + 1][yCoord] == ' ') || (mazeArray[xCoord + 1][yCoord] == '*') || (mazeArray[xCoord + 1][yCoord] == 'E')) {
							mazeArray[xCoord][yCoord] = '*';
							xCoord = add(xCoord);
						}
					}else if((mazeArray[xCoord + 1][yCoord] == ' ') || (mazeArray[xCoord + 1][yCoord] == '*') || (mazeArray[xCoord + 1][yCoord] == 'E')) {
						mazeArray[xCoord][yCoord] = '*';
						xCoord = add(xCoord);
						direction = changeDirection(Direction.LEFT);
					}else if((mazeArray[xCoord][yCoord - 1] == ' ') || (mazeArray[xCoord][yCoord - 1] == '*')) {
						mazeArray[xCoord][yCoord] = '*';
						yCoord = sub(yCoord);
						direction = changeDirection(Direction.LEFT);
					}
				 }else if(direction.equals(Direction.RIGHT)) {
					if(mazeArray[xCoord + 1][yCoord] == 'E') {
						xCoord = add(xCoord);
					}else if((mazeArray[xCoord + 1][yCoord] == '#') || (mazeArray[xCoord + 1][yCoord] == 'E')) {
						if((mazeArray[xCoord][yCoord + 1] == ' ') || (mazeArray[xCoord][yCoord + 1] == '*')) {
							mazeArray[xCoord][yCoord] = '*';
							yCoord = add(yCoord);
						}else if(mazeArray[xCoord - 1][yCoord] == ' ') {
							mazeArray[xCoord][yCoord] = '*';
							xCoord = sub(xCoord);
							direction = changeDirection(Direction.UP);
						}else if(mazeArray[xCoord][yCoord + 1] == '#') {
							mazeArray[xCoord][yCoord] = '*';
							direction = changeDirection(Direction.LEFT);
						}
					}else if((mazeArray[xCoord + 1][yCoord] == ' ') || (mazeArray[xCoord + 1][yCoord] == '*') || (mazeArray[xCoord+ 1][yCoord] == 'E')) {
						mazeArray[xCoord][yCoord] = '*';
						xCoord = add(xCoord);
						direction = changeDirection(Direction.DOWN);
					}else if((mazeArray[xCoord + 1][yCoord] == ' ') && (mazeArray[xCoord][yCoord + 1] == ' ')) {
						mazeArray[xCoord][yCoord] = '*';
						direction = changeDirection(Direction.DOWN);
					}
				 }else if(direction.equals(Direction.LEFT)) {
					if(mazeArray[xCoord - 1][yCoord] == 'E') {
						xCoord = sub(xCoord);
					}else if((mazeArray[xCoord - 1][yCoord] == '#') || (mazeArray[xCoord - 1][yCoord] == 'E')) {
						if((mazeArray[xCoord][yCoord - 1] == ' ') || (mazeArray[xCoord][yCoord - 1] == '*')) {
							mazeArray[xCoord][yCoord] = '*';
							yCoord = sub(yCoord);
						}else if((mazeArray[xCoord][yCoord - 1] == '#') && ((mazeArray[xCoord + 1][yCoord] == ' ') || (mazeArray[xCoord + 1][yCoord] == '*'))) {
							mazeArray[xCoord][yCoord] = '*';
							xCoord = add(xCoord);
							direction = changeDirection(Direction.DOWN);
						}else if((mazeArray[xCoord - 1][yCoord] == ' ') || (mazeArray[xCoord - 1][yCoord] == '*')) {
							mazeArray[xCoord][yCoord] = '*';
							xCoord = sub(xCoord);
							direction = changeDirection(Direction.UP);
						}else if((mazeArray[xCoord][yCoord - 1] == '#') && (mazeArray[xCoord + 1][yCoord] == '#')) {
							mazeArray[xCoord][yCoord] = '*';
							direction = changeDirection(Direction.RIGHT);
						}
					}else if((mazeArray[xCoord - 1][yCoord] == ' ') || (mazeArray[xCoord - 1][yCoord] == '*') || (mazeArray[xCoord - 1][yCoord] == 'E')) {
						mazeArray[xCoord][yCoord] = '*';
						xCoord = sub(xCoord);
						direction = changeDirection(Direction.UP);
					}else if((mazeArray[xCoord - 1][yCoord] == '#') && (mazeArray[xCoord][yCoord - 1] == '#')) {
						if(mazeArray[xCoord + 1][yCoord] == ' ') {
							mazeArray[xCoord][yCoord] = '*';
							yCoord = sub(yCoord);
							direction = changeDirection(Direction.DOWN);
						}
					}
				}
				System.out.println(xCoord + "," + yCoord);
				if((xCoord == eX) && (yCoord == eY)) {
					mazeArray[xCoord][yCoord] = '*';
					break;
				}
			 }
			 for(int cooount = 0;cooount < mazeArray.length;cooount ++) {
				 for(int coount = 0;coount < mazeArray[0].length;coount ++) {
					 System.out.print(mazeArray[cooount][coount]);
				 }
				 System.out.println();
			 }
		}finally {
			reader.close();
		}
	}
	
	public static enum Direction {
		UP,DOWN,RIGHT,LEFT
	}
	
	private static char[][] fileToArray() throws IOException {
		
		int rows;
		int columns;
		String fileLine;
		
		LineNumberReader lnr = new LineNumberReader(new FileReader(file)); //gets number of rows of maze
		lnr.skip(Long.MAX_VALUE);
		rows = lnr.getLineNumber() + 1;
		lnr.close();
		
		BufferedReader br = new BufferedReader(new FileReader(file)); //gets number of columns
		fileLine = br.readLine();
		columns = fileLine.length();
		
		mazeArray = new char[rows][columns];
		
		for(int count = 0;count < rows;count ++) {
			if(count != 0) {
				fileLine = br.readLine();
			}
			int foo = 0;
			lineArray = fileLine.toCharArray();
			for(char i : lineArray) {
				if(i == 'S') {
					sX = foo;
					sY = count;
				}else if(i == 'E') {
					eX = foo;
					eY = count;
				}
				mazeArray[count][foo] = i;
				foo ++;
			}
		}
		br.close();
		return mazeArray;
	}
	
	public static int add(int start) {
		start += 1;
		return start;
	}
	
	public static int sub(int start) {
		start -= 1;
		return start;
	}
	
	public static Direction changeDirection(Direction dir) {
		return dir;
	}
}