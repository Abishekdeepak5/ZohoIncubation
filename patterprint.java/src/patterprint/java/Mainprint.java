package patterprint.java;

import java.util.Scanner;

public class Mainprint {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int start=1,temp=0;
		for(int i=0;i<n;i++) {
			temp+=i+2;
			for(int j=0;j<n;j++) {
				if(temp>=n) {
					System.out.print(temp-- + " ");
				}else {					
					System.out.print(temp++ +" ");
				}
				
			}
			start+=i;
			System.out.println();
		}

	}
}
