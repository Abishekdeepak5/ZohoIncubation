package stringProgram;

public class longString {
	static boolean isPalindrom(String s,int left,int right) {
		while(left<=right) {
			System.out.print(s.charAt(left)+"-"+s.charAt(right)+"  "); 
			if(s.charAt(left)!=s.charAt(right)) {
				System.out.println();
				return false;
			}
			left++;
			right--;
		}
		System.out.println();
		return true;
	}
	public static void main(String[] args) {
		String str="aabccba";
		int i=0,j=0,k=0;
		int n=str.length();
		for(i=0;i<n;i++) {
			for(j=0;j<=i;j++) {
				System.out.print(j+"-"+(n-i+j-1)+" ");
				if(isPalindrom(str,j,n-i+j-1)) {
					System.out.print(str.substring(j,n-i+j));
					return;
				}
			}
			System.out.println();
		}
	}

}
