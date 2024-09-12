package practice;

public class RemoveString {

	public static void main(String[] args) {
		String s="aacabaaac";
		char[] sList=s.toCharArray();
		String s1="";
		int n=sList.length;
		for(int i=0;i<n;i++) {
//			if(sList[i]!='b') {
//				s1+=sList[i];
//			}
			 if((sList[i]=='b') {
				 continue;
			 }
			 s1+=sList[i];
		}
		System.out.println(s1);
	}

}
