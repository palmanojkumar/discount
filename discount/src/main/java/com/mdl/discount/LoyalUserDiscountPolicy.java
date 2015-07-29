package com.mdl.discount;


/**
 * @author palmanojkumar
 *
 */
public class LoyalUserDiscountPolicy extends AbstractDiscountPolicy {

	private static final String POLICY_NAME = "LOYAL_USER_DISCOUNT";
	private double discount;

	public LoyalUserDiscountPolicy() {
		this(5.0);
	}

	public LoyalUserDiscountPolicy(double percentage) {
		this.discount = percentage / (double) 100;
	}

	public String getPolicyName() {
		return POLICY_NAME;
	}

	public double getDiscount(double amount, Context context) {
		if ((context.getUserProfile().timeSinceUserJoined() > 2) && (context.getProductType()==ProductType.NonGrocery)) {
			return amount * discount;
		}
		return -1;
	}

}
