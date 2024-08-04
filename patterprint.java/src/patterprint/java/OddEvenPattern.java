package patterprint.java;

public class OddEvenPattern {
	public static void main(String[] args) {
		int curr=1,stepMinus=1;
		int n=10;
		System.out.println(1);
		for(int i=1;i<n;i++) {
			curr+=stepMinus;
			
			for(int j=0;j<=i;j++) {
				System.out.print(curr+" ");
				curr+=2;
			}
			
			curr-=2;
			if(i%2==1) {
				stepMinus-=2;
			}
			System.out.println();
		}
	}
}

//int oddCount=-1,evenCount=0,currCount=0;
//int n=15;
//for(int i=0;i<n;i++) {
//	for(int j=0;j<=i;j++) {
//		if(i%2==0) {
//			oddCount+=2;
//			System.out.print(oddCount+" ");
//		}
//		else{
//			evenCount+=2;
//			System.out.print(evenCount+" ");
//		}
//	}System.out.println();
//}