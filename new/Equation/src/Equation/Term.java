package Equation;

class Term{
	private int coefficient=1;
	Variable[] variables;
	static EquationHelper helper=new EquationHelper();
	
	public static Term parseTerm(String term) {
		Term t=new Term();
		t.coefficient=helper.findCoefficient(term);
		t.variables=new Variable[term.length()];
		int count=0;
		String[] variableList=helper.findVariables(term);
		for(String s:variableList) {
			if(s!=null) {
//				s=helper.sortString(s);
				t.variables[count++]=Variable.parseVariable(s);
			}
		}
		helper.sortString(t.variables);
		return t;
	}

	public Term multiply(Term other) {
		Term term=new Term();
			term.coefficient=this.coefficient*other.coefficient;
			int i=0,j=0,count=0;
			term.variables=new Variable[100];
			this.variables=helper.reduceArray(this.variables);
			other.variables=helper.reduceArray(other.variables);
			int teamCount1=this.variables.length;
			int teamCount2=other.variables.length;
			
		while(i<teamCount1 && j<teamCount2) {
			if(this.variables[i]!=null && other.variables[j]!=null && this.variables[i].getVariable()==other.variables[j].getVariable()) {
				term.variables[count++]=new Variable(this.variables[i].getVariable(),this.variables[i].getPower()+other.variables[j].getPower());
				i++;
				j++;
			}
			else {
				break;
			}
		}
		while(i<teamCount1) {
			if(this.variables[i]!=null) {
				term.variables[count++]=new Variable(this.variables[i].getVariable(),this.variables[i].getPower());
			}
				i++;
		}
		while(j<teamCount2) {
			if(this.variables[j]!=null) {
				term.variables[count++]=new Variable(other.variables[j].getVariable(),other.variables[j].getPower());
			}
			j++;
		}
		term.variables=helper.reduceArray(term.variables);
		return term;
	}
	
	@Override
	public String toString() {
		String printString="";
		printString+=coefficient;
		try {
			
		for(Variable v:variables) {
			if(v!=null) {
				printString+=v.getVariable();
				printString+="^"+v.getPower();				
			}
		}
		}catch(Exception e) {
//			System.out.println(e.getMessage());
		}
		return printString+" ";
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public Variable[] getVariables() {
		return variables;
	}

	public void setVariables(Variable[] variables) {
		this.variables = variables;
	}
	
	
}

