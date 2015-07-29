package com.mdl.discount;

/**
 * @author palmanojkumar
 *
 */
public interface DiscountStrategy {

	double apply(double amount, Context context);
}
