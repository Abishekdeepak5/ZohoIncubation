package patterprint.java;

public class Diamond {
	public static void main(String[] args) {
		int n=5;
		if(n%2==0) {
			n-=1;
		}
		int starCount=1;
		int sign=1;
		for(int i=0;i<n;i++) {
			int spaceCount=Math.abs((n/2)-i);
			for(int j=0;j<spaceCount;j++) {
				System.out.print("  ");
			}
			for(int j=0;j<starCount;j++) {
				System.out.print("* ");
			}
			if(i>=n/2) {
				sign=-1;
			}
			starCount=(starCount+(sign*2));
			System.out.println();
		}
	}
}
