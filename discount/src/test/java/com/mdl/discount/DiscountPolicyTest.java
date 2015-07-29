package com.mdl.discount;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.TestCase;

public class DiscountPolicyTest extends TestCase {

	public void testAffiliatedDiscountPolicy_UserAffiliated_NonGroceryProducts() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.NonGrocery);
		UserProfile profile = mock(UserProfile.class);
		when(profile.isAffiliatedUser()).thenReturn(true);
		when(context.getUserProfile()).thenReturn(profile);
		
		DiscountPolicy policy = new AffiliatedUserDiscountPolicy();
		assertEquals(10.0, policy.getDiscount(100, context));
	}
	
	public void testEmployeeDiscountPolicy_UserIsEmployee_NonGroceryProducts() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.NonGrocery);
		UserProfile profile = mock(UserProfile.class);
		when(profile.isEmployee()).thenReturn(true);
		when(context.getUserProfile()).thenReturn(profile);
		
		DiscountPolicy policy = new EmployeeDiscountPolicy();
		assertEquals(30.0, policy.getDiscount(100, context));
	}
	
	public void testEmployeeDiscountPolicy_UserIsEmployee_GroceryProducts() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.Grocery);
		UserProfile profile = mock(UserProfile.class);
		when(profile.isEmployee()).thenReturn(true);
		when(context.getUserProfile()).thenReturn(profile);
		
		DiscountPolicy policy = new EmployeeDiscountPolicy();
		assertEquals(-1.0, policy.getDiscount(100, context));
	}
	
	public void testLoyalUserDiscountPolicy_MoreThanTwoYears_GroceryProducts() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.Grocery);
		UserProfile profile = mock(UserProfile.class);
		when(profile.timeSinceUserJoined()).thenReturn(3);
		when(context.getUserProfile()).thenReturn(profile);
		
		DiscountPolicy policy = new LoyalUserDiscountPolicy();
		assertEquals(-1.0, policy.getDiscount(100, context));
	}
	
	public void testLoyalUserDiscountPolicy_MoreThanTwoYears_NonGroceryProducts() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.NonGrocery);
		UserProfile profile = mock(UserProfile.class);
		when(profile.timeSinceUserJoined()).thenReturn(3);
		when(context.getUserProfile()).thenReturn(profile);
		
		DiscountPolicy policy = new LoyalUserDiscountPolicy();
		assertEquals(5.0, policy.getDiscount(100, context));
	}
	
	public void testLoyalUserDiscountPolicy_LessThanTwoYears_GroceryProducts() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.Grocery);
		UserProfile profile = mock(UserProfile.class);
		when(profile.timeSinceUserJoined()).thenReturn(2);
		when(context.getUserProfile()).thenReturn(profile);
		
		DiscountPolicy policy = new LoyalUserDiscountPolicy();
		assertEquals(-1.0, policy.getDiscount(100, context));
	}
	
	public void testLoyalUserDiscountPolicy_LessThanTwoYears_NonGroceryProducts() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.NonGrocery);
		UserProfile profile = mock(UserProfile.class);
		when(profile.timeSinceUserJoined()).thenReturn(2);
		when(context.getUserProfile()).thenReturn(profile);
		
		DiscountPolicy policy = new LoyalUserDiscountPolicy();
		assertEquals(-1.0, policy.getDiscount(100, context));
	}
	
	public void testHundredDollarDiscountPolicy() {
		Context context = mock(Context.class);
		
		DiscountPolicy policy = new HundredDollarDiscountPolicy();
		assertEquals(45.0, policy.getDiscount(990, context));
	}
	
	public void testHighestAnyOfDiscountPolicy_UserIsAffiliated_MoreThan2yeares_NonGroceryProducts() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.NonGrocery);
		UserProfile profile = mock(UserProfile.class);
		when(profile.isAffiliatedUser()).thenReturn(true);
		when(profile.timeSinceUserJoined()).thenReturn(3);
		when(context.getUserProfile()).thenReturn(profile);
		
		DiscountPolicy policy = new HighestAnyOfDiscountPolicy();
		assertEquals(10.0, policy.getDiscount(100, context));
	}
	
	public void testHighestAnyOfDiscountPolicy_UserIsAffiliated_LessThan2yeares_NonGroceryProducts() {
		//TODO: 
	}
	
	public void testHighestAnyOfDiscountPolicy_NonAffiliatedUser_LessThan2yeares_NonGroceryProducts() {
		//TODO:
	}
	
	public void testHighestAnyOfDiscountPolicy_NonAffiliatedUser_MoreThan2yeares_NonGroceryProducts() {
		//TODO:
	}
	
	
}
