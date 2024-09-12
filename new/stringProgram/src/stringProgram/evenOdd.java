package stringProgram;

public class evenOdd {
	
	static void printArray(int[] array) {
		for(int element:array) {
			if(element==0) {
				break;
			}
			System.out.print(element+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr= {1,23,12,34,45,22,14};
		int[] evenarr=new int[arr.length];
		int[] oddarr=new int[arr.length];
		
		int evencount=0,oddcount=0;
		
		for(int element:arr) {
			if(element%2==0) {
				evenarr[evencount++]=element;
			}else {
				oddarr[oddcount++]=element;
			}
		}

		printArray(evenarr);
		printArray(oddarr);
	}

}
