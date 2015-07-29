package com.mdl.discount;

/**
 * @author palmanojkumar
 *
 */
public class HundredDollarDiscountPolicy extends AbstractDiscountPolicy {

	private static final String POLICY_NAME = "HUNDRED_DOLLAR_DISCOUNt";
	private double discount;
	
	public HundredDollarDiscountPolicy() {
		this(5.0);
	}
	
	public HundredDollarDiscountPolicy(double discount) {
		this.discount = discount;
	}
	public String getPolicyName() {
		return POLICY_NAME;
	}

	public double getDiscount(double amount, Context context) {
		
		return ((amount-(amount%100))/100)*discount;

	}
	
}
