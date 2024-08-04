package Equation;

import java.util.ArrayList;

public interface IEquationHelper {
	boolean isDigit(char c);
	String[] splitTerm(String equation);
	int findCoefficient(String term);
	public int findPower(String number);
	public void sortString(Variable[] variables);
	public int findLength(Variable[] variable);
}

class EquationHelper implements IEquationHelper{
	public boolean isDigit(char c) {
		return c>='0' && c<='9';
	}
	
	public String[] splitTerm(String expression ) {	
        String[] parts=new String[expression .length()];
        StringBuilder currentPart = new StringBuilder();
        int count=0;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+') {
                parts[count++]=currentPart.toString();
                currentPart.setLength(0);
            }
            else if(ch=='-') {
            	if(i!=0) {
            		parts[count++]=currentPart.toString();
            		currentPart.setLength(0);            		
            	}
                currentPart.append(ch);
            }
            else {
                currentPart.append(ch);
            }
        }
        parts[count]=currentPart.toString();
		return parts;
	}
	
	public int findCoefficient(String term) {
		boolean isMinus=false;
		int coefficient=0;
		for(char c:term.toCharArray()) {
			if(c=='-') {
				isMinus=true;
			}
			else if(isDigit(c)) {
				coefficient=coefficient*10+(c-48);
			}
			else {
				break;
			}
		}
		
		if(isMinus==true) {
			coefficient*=-1;
		}
		if(coefficient==0)
			coefficient=1;
		return coefficient;
	}
	
	 public String[] findVariables(String term) {
		 	String[] variableStr=new String[term.length()];
		 	int count=0;
	        int i = 0;
	        while (i < term.length() && (isDigit(term.charAt(i)) || term.charAt(i) == '+' || term.charAt(i) == '-')) {
	            i++;
	        }
	        
	        while (i < term.length()) {
	        	String tvariable="";
	        	tvariable+=term.charAt(i);
	            i++;
	            if (i < term.length() && term.charAt(i) == '^') {
	            	tvariable+="^";
	                i++;
	                while (i < term.length() && isDigit(term.charAt(i))) {
	                    tvariable+=term.charAt(i);
	                    i++;
	                }
	            }
	            variableStr[count++]=tvariable;
	        }
	        return variableStr;
	    }
	 	
	 	@Override
	 	public int findPower(String number) {
	 		int i=1;
	 		int power=0;
	 		if(number.length()==1) {
	 			return 1;
	 		}
	 		i++;
	 		while (i < number.length()) {
	 			power= power * 10 + (number.charAt(i) - '0');
	 			i++;
	 		}
	 		return power;
	 	}	
	 	
	 	public void sortString(Variable[] variables) {
	 		int n=variables.length;
	 		for(int i=0;i<n-1;i++) {
	 			for(int j=0;j<n-i-1;j++) {
	 				if(variables[j]!=null && variables[j+1]!=null && variables[j].getVariable()>variables[j+1].getVariable()) {
	 					Variable t=variables[j];
	 					variables[j]=variables[j+1];
	 					variables[j+1]=t;
	 				}
	 			}
	 		}
	 	}
	 	
	 	public int findLength(Variable[] variable) {
			int count=0;
			for(Variable v:variable) {
				count++;
			}
			return count;
		}
	 	
	 	public Variable[] reduceArray(Variable[] originalArray ) {
	 	     int filledCount = 0;
	         for (Variable num : originalArray) {
	             if (num != null) {
	                 filledCount++;
	             }
	         }
	         Variable[] reducedArray = new Variable[filledCount];
	         int index = 0;
	         for (Variable num : originalArray) {
	             if (num != null) {
	                 reducedArray[index++] = num;
	             }
	         }
	         return reducedArray;
	 	}
}