package com.mdl.discount;

/**
 * For simplification, ruled out singleton requirement for this manager.
 * 
 * @author palmanojkumar
 *
 */
public class DiscountManager {

	private DiscountStrategy discountStrategy;
	
	/**
	 * for simplification, context is directly used but ideally a context service should be used to get appropriate context for provided user id.
	 */
	private Context context;
	
	
	public DiscountManager(DiscountStrategy discountStrategy, Context context) {
		this.discountStrategy = discountStrategy;
		this.context = context;
	}
	
	
	
	public double getNetPayable(double amount) {
		return discountStrategy.apply(amount, context);
	}
	
	
}
