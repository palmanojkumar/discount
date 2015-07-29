package com.mdl.discount;


/**
 * @author palmanojkumar
 *
 */
public class AffiliatedUserDiscountPolicy extends  AbstractDiscountPolicy {

	private static final String NAME = "AFFILIATION_DISCOUNT";
	private double discount;
	
	public AffiliatedUserDiscountPolicy() {
		this(10.0);
	}
	
	public AffiliatedUserDiscountPolicy(double percentage) {
		this.discount = percentage/(double)100;
	}
	
	public String getPolicyName() {
		return NAME;
	}

	public double getDiscount(double amount, Context context) {
		if (context.getUserProfile().isAffiliatedUser() && (context.getProductType()==ProductType.NonGrocery)) {
			
			return amount*discount;
		}
		return -1;
	}
	
}
