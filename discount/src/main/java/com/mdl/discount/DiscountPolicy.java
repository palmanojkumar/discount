package com.mdl.discount;

/**
 * @author palmanojkumar
 *
 */
public interface DiscountPolicy {

	String getPolicyName();

	double getDiscount(double amount, Context context);
}
