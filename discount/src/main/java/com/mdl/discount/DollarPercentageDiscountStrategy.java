package com.mdl.discount;

import java.util.HashSet;
import java.util.Set;

/**
 * @author palmanojkumar
 *
 */
public class DollarPercentageDiscountStrategy implements DiscountStrategy {

	private Set<DiscountPolicy> policies = new HashSet<DiscountPolicy>();
	
	public DollarPercentageDiscountStrategy() {
		this(new HighestAnyOfDiscountPolicy(), new HundredDollarDiscountPolicy());
	}
	
	public DollarPercentageDiscountStrategy(DiscountPolicy... policies) {
		for (DiscountPolicy policy : policies) {
			this.policies.add(policy);
		}
	}
	
	
	public double apply(double amount, Context context) {
		double totalDiscount = 0;
		for (DiscountPolicy policy : policies) {
			totalDiscount += policy.getDiscount(amount, context);
		}
		return amount-totalDiscount;
	}

}
