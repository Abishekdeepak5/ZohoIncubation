package stringProgram;

public class GreatestNumber {
	public static int findBaseNumber(int number) {
		int value=0;
		while(number>0) {
			value=number%10;
			number=number/10;
			
		}
		return value;
	}
	public static void main(String[] args) {
		int[] arr= {1,19,9,7,31};
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-i-1;j++) {
//				System.out.println(findBaseNumber(arr[j])+" "+findBaseNumber(arr[j+1]));
				if(findBaseNumber(arr[j])<findBaseNumber(arr[j+1])) {
					int t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}

}
