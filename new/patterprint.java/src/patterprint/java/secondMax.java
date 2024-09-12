package patterprint.java;

public class secondMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {20,12,13,9,6,11,21};
		int maxValue=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]>maxValue) {
				second=maxValue;
				maxValue=arr[i];
			}else if(second<arr[i]) {
				second=arr[i];
			}
		}
		System.out.println(second);

	}

}
