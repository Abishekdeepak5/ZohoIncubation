package Equation;

class Variable{
	private char variable;
	private int power;
	static EquationHelper helper=new EquationHelper();

	public Variable() {}
	public Variable(char variable, int power) {
		this.variable = variable;
		this.power = power;
	}

	public static Variable parseVariable(String term) {
		Variable v=new Variable();
		v.variable=term.charAt(0);
		v.power=helper.findPower(term);
		return v;
	}

	@Override
	public String toString() {
		return "Variable [variable=" + variable + ", power=" + power + "]";
	}

	public char getVariable() {
		return variable;
	}

	public void setVariable(char variable) {
		this.variable = variable;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
}

