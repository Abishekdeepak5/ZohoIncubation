package stringProgram;
public class longestWord {
	public static int MaxElement(int val1,int val2) {
		return val1>val2?val1:val2;
	}
	public static void main(String[] args) {
		String str="i am engineering  student";
		char[] cList=str.toCharArray();
		int n=cList.length,i=0,j=1,currValue,maxValue=-1,maxi=0,maxj=0;
		int count=0;
		while(j<n) {
			if(cList[j]==' ' || j==n-1) {
				if(maxValue<count) {
					maxValue=count;
					maxj=j;
					maxi=i;
				}
				if(j+1<n && cList[j+1]!=' ') {
					i=j+1;
				}
				count=0;
			}
			else {				
				count++;
			}
			j++;
		}
		
//		System.out.println(maxi+" "+maxj);
		while(maxi<=maxj) {
			System.out.print(cList[maxi++]);
		}
	}
}