package stringProgram;

public class swapElement {
	static void ReverseArray(int arr[],int start,int end) {
		while(start<end) {
			int t=arr[start];
			arr[start]=arr[end];
			arr[end]=t;
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		int[] arr= {10,12,13,15,9,5,7,3,1,45,35,21};
		int swapCount=4;
		int n=arr.length/swapCount;
		
		for(int i=0;i<n;i++) {
			int swapIndex=(swapCount*(i+1))-1;
			int currIndex=swapCount*i;
			ReverseArray(arr,currIndex,swapIndex);
		}
		
		int RemainingStart=n*swapCount;
		int size=arr.length-1;
		ReverseArray(arr,RemainingStart,size);
		
		for(int a:arr) {
			System.out.print(a+" ");
		}

	}

}
