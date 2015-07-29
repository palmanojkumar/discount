package com.mdl.discount;

/**
 * @author palmanojkumar
 *
 */
public class EmployeeDiscountPolicy extends AbstractDiscountPolicy {

	private static final String POLICY_NAME = "EMP_DISCOUNT";
	private double discount;

	public EmployeeDiscountPolicy() {
		this(30.0);
	}

	public EmployeeDiscountPolicy(double percentage) {
		this.discount = percentage / (double) 100;
	}

	public String getPolicyName() {
		return POLICY_NAME;
	}

	public double getDiscount(double bill, Context context) {
		if (context.getUserProfile().isEmployee() && (context.getProductType()==ProductType.NonGrocery)) {
			return bill * discount;
		}
		return -1;
	}

}
