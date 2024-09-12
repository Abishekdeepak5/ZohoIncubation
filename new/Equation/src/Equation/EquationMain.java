package Equation;


class Equation{
	static EquationHelper helper=new EquationHelper();
	private Term[] terms;
	
	public static Equation parseEquation(String equation) {
		Term[] termsList;
		String[] terms=helper.splitTerm(equation);
		int count=0;
		termsList=new Term[terms.length];
		for(String t:terms) {
			if(t!=null) {
				termsList[count++]=Term.parseTerm(t);
			}
		}
		Equation tEquation=new Equation();
		tEquation.terms=termsList;
		return tEquation;
	}
	
	@Override
	public String toString() {
		String termString="";
		for(int i=0;i<terms.length;i++) {
			if(terms[i]!=null) {
				termString+=terms[i];
			}
		}
		return termString;
	}
	

	public Equation multiply(Equation other) {
	    Equation result = new Equation();
	    result.terms=new Term[100];
	    int count=0;
	    for (Term t1 : this.terms) {
	        for (Term t2 : other.terms) {
	        	if(t1!=null && t2!=null) {	        		
	        		Term multipliedTerm = t1.multiply(t2);
	            result.terms[count++]=multipliedTerm;
	        	}
//	        	if(t1!=null && t2!=null) {	        
//	        		System.out.print(t1.getCoefficient()+" "+t2.getCoefficient());
//	        	}
	        }
//	        System.out.println();
	    }
	    return result;
	}
	
	
}
public class EquationMain {
	public static void main(String[] args) {
		Equation equation1=Equation.parseEquation("2x+2y-4xz");
		System.out.println(equation1);

		Equation equation2=Equation.parseEquation("2x+2y^12");
		System.out.println(equation2);
		
		Equation equation3=equation1.multiply(equation2);
		System.out.println(equation3);
	
	}

}

