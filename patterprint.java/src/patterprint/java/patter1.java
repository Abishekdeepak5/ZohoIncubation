package patterprint.java;

import java.util.Scanner;

public class patter1 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int start=1;
		for(int i=0;i<n;i++) {
			int temp=start;
			for(int j=1;j<=n-i;j++) {
				System.out.print(temp+" ");
				temp=temp+j+1+i;	
			}
			start+=i+1;
			System.out.println();
		}

	}


}
