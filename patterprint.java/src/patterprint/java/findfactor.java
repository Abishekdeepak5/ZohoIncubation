package patterprint.java;

public class findfactor {

	static int findfactor(int value) {
		int count=0;
		for(int i=1;i<=value;i++) {
			if(value%i==0) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,12,13,9,6};
		int[] count=new int[5];
		int n=arr.length;	
		for(int i=0;i<n;i++) {
			count[i]=findfactor(arr[i]);
//			System.out.println(count[i]);
		}
		
//		for(int i=0;i<n;i++) {
//			int minvalue=count[i],ind=i;
//			for(int j=i+1;j<n;j++) {
//				if(minvalue>count[j]) {
//					minvalue=count[j];
//					ind=j;
//				}
//				
//			}
//			if(i!=ind) {
//				int temp1=count[i];
//				int temp2=arr[i];
//				arr[i]=arr[ind];
//				count[i]=count[ind];
//				arr[ind]=temp1;
//				count[ind]=temp2;
//
//			}
//		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(count[j]>count[j+1]) {
					int temp1=count[j+1];
					int temp2=arr[j+1];
					arr[j+1]=arr[j];
					count[j+1]=count[j];
					count[j]=temp1;
					arr[j]=temp2;
				}
			}
		}
		for(int a:count) {
			System.out.print(a+" ");
		}

	}

}
