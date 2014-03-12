import java.util.*;

public class CombinationLock {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Integer lockSize = 0;
		int[]combo = new int[3];
		Integer runningTotal = 0;
		
		try {
			System.out.println("Enter the input");
			lockSize = sc.nextInt();
			for(int i = 0;i < 3;i ++) {
				combo[i] = sc.nextInt();
			}
		}finally {
			sc.close();
		}
		
		runningTotal += 3 * lockSize + combo[0];
		runningTotal += (lockSize - combo[1]) + combo[0];
		runningTotal += combo[2] - combo[1];
		
		System.out.println(runningTotal);
	}
}
