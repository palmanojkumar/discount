package com.mdl.discount;

/**
 * @author palmanojkumar
 *
 */
public abstract class AbstractDiscountPolicy implements DiscountPolicy {
	
	@Override
	public int hashCode() {
		return getPolicyName().hashCode();
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
			return false;
		}
		
		if (!(otherObject instanceof DiscountPolicy)) {
			return false;
		}
		
		return ((DiscountPolicy)otherObject).getPolicyName().equals(getPolicyName());
	}
}
