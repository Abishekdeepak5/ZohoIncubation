package stringProgram;

public class reverseWord {
	public static boolean isPrsent(char[] clist,int i,char[] findList) {
		int nFind=findList.length+i,j=0;
		while(i<clist.length && j<nFind && j<findList.length) {
			if(clist[i]!=findList[j]) {
				return false;
			}
			j++;i++;
		}
		return true;
	}
	public static void main(String[] args) {
		
		String str="Government college";
		String find="t col";
		char[] cList=str.toCharArray();
		char[] fList=find.toCharArray();
		int n=cList.length,i=0;
		
		while(i<n) {
			if( isPrsent(cList,i,fList)==true ) {
				System.out.println(i);
				break;
			}
			i++;
		}
		if(i==n) {
			System.out.println("-1");
		}
		
	}

}
