package stringProgram;

class bracket {
	
	public static void main(String[] args) {
		String str="()[]{}";
		char[] charList=str.toCharArray();
		int i=0,n=str.length();
		MyStack stack=new MyStack(n); 
		while(i<n) {
			char curr=charList[i];
			if(curr=='(' ||curr=='{' && curr=='[' ) {				
				stack.push(curr);
			}
			else if(curr==')' && stack.peek()!='(') {
				break;
			}
			else if(curr==']' && stack.peek()!='[') {
				break;
			}
			else if(curr=='}' && stack.peek()!='{') {
				break;
			}
				i++;
		}
		if(stack.top!=-1) {
			System.out.println("false");
		}else {
			System.out.println("true");
		}

	}

}
class MyStack {
 int top=-1;
 char[] stack;
 public MyStack(int size){
	 stack=new char[size];
 }
 public void push(char value) {
	 stack[++top]=value;
 }
 
 public char pop(char value) {
	 return stack[top--];
 }
 public char peek() {
	 return stack[top];
 }
}