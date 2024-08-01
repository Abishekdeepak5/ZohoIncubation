package stringProgram;

public class strReverse {

	static boolean isAlphapet(char c) {
		if((c>=65 && c<=90)||(c>=97 && c<=122)) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String str="Abishek, hi how are you?";
		int start=0,end=str.length()-1;
		char[] strArray=str.toCharArray();
		while(start<=end) {
			boolean isStartChar=isAlphapet(str.charAt(start));
			
			if(isStartChar && isAlphapet(str.charAt(end))) {
				char t=strArray[start];
				strArray[start]=strArray[end];
				strArray[end]=t;
				start++;
				end--;
			}
			else if(isStartChar==false) {
				start++;
			}else {
				end--;
			}	
			
		}
		for(char s:strArray) {
			System.out.print(s);
		}
		
	}

}
