package stringProgram;

public class AddSubMulDiv {

	public static void main(String[] args) {
		String str="451++";
		char[] cList=str.toCharArray();
		int i=0,j=0,n=cList.length;
		int value=cList[0]-'0';
		
		while(j<n && cList[j]>'0' && cList[j]<'9') {
				j++;
		}
		i++;
		while(j<n) {
			if(cList[j]=='+') {
				value+=(cList[i]-'0');
			}
			else if(cList[j]=='-') {
				value-=(cList[i]-'0');
			}
			else if(cList[j]=='*') {
				value*=(cList[i]-'0');
			}
			else if(cList[j]=='/') {
				value/=(cList[i]-'0');
			}
			i++;
			j++;
		}
		System.out.println(value);

	}

}
