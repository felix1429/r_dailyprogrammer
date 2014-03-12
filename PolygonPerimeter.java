import java.util.*;

public class PolygonPerimeter {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Double radiusVar;
		Double sideVar;
		Double answer;
		
		try {
			System.out.println("Input the number of sides");
			sideVar = Double.valueOf(sc.nextLine());
			System.out.println("Input the circumradius");
			radiusVar = Double.valueOf(sc.nextLine());
			answer = (2 * radiusVar * Math.sin(Math.PI/sideVar));
			System.out.println((double)Math.round((answer * sideVar) * 1000) / 1000);
		}finally {
			sc.close();
		}
	}
}