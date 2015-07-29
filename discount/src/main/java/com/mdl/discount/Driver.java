package com.mdl.discount;

/**
 * @author palmanojkumar
 *
 */
public class Driver {
	public static void main(String[] args) {
		DiscountPolicy policy = new HundredDollarDiscountPolicy();
		System.out.println(policy.getDiscount(240, null));
	}
}
