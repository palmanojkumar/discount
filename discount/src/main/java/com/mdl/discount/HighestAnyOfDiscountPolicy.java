package com.mdl.discount;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author palmanojkumar
 *
 */
public class HighestAnyOfDiscountPolicy extends AbstractDiscountPolicy {

	private static final String POLICY_NAME = "HIGHEST_ANY_OF";

	private Set<DiscountPolicy> policies = new HashSet<DiscountPolicy>();
	
	public HighestAnyOfDiscountPolicy() {
		this(new AffiliatedUserDiscountPolicy(), new EmployeeDiscountPolicy(), new LoyalUserDiscountPolicy());
	}
	
	public HighestAnyOfDiscountPolicy(DiscountPolicy... policies) {
		for (DiscountPolicy policy : policies) {
			this.policies.add(policy);
		}
	}

	public double getDiscount(double amount, Context context) {
		Set<Double> discountSet = new HashSet<Double>();
		for (DiscountPolicy policy : policies) {
			discountSet.add(policy.getDiscount(amount, context));
		}

		double finalDiscount = Collections.max(discountSet); 
		if (finalDiscount == -1.0) {
			finalDiscount = 0;
		}
		return finalDiscount;
	}

	public String getPolicyName() {
		return POLICY_NAME;
	}

	public void addPolicy(DiscountPolicy policy) {
		policies.add(policy);
	}

	public boolean removePolicy(DiscountPolicy policy) {
		return policies.remove(policy);
	}

}
