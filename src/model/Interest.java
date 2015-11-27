package model;

public class Interest {
	private int principalAmount;
	private int years;
	private int compounded;
	private double rate;
	
	public Interest(int principalAmount, double rate, int years, int compounded){
		this.principalAmount = principalAmount;
		this.rate = rate/100;
		this.years = years;
		this.compounded = compounded;
	}
	
	public double calculateInterest(){
		return principalAmount * Math.pow((1 + this.rate/this.compounded),this.compounded*this.years);
	}
}
