//http://www.reddit.com/r/dailyprogrammer/comments/1v4cjd/011314_challenge_148_easy_combination_lock/cfy31c8?context=3

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
