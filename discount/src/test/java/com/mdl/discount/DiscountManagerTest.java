package com.mdl.discount;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.TestCase;

public class DiscountManagerTest extends TestCase {
	
	public void testDiscountManager_UserIsEmployee_UserIsLoyal_UserIsAffiliated_NonGroceryProduct_BillMoreThan100() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.NonGrocery);
		
		UserProfile profile = mock(UserProfile.class);
		when(profile.isEmployee()).thenReturn(true);
		when(profile.timeSinceUserJoined()).thenReturn(3);
		when(profile.isAffiliatedUser()).thenReturn(true);
		when(context.getUserProfile()).thenReturn(profile);

		DiscountManager manager = new DiscountManager(new DollarPercentageDiscountStrategy(), context);
		assertEquals(158.0, manager.getNetPayable(240));
	}
	
	public void testDiscountManager_UserIsEmployee_UserIsLoyal_UserIsAffiliated_NonGroceryProduct_BillLessThan100() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.NonGrocery);
		
		UserProfile profile = mock(UserProfile.class);
		when(profile.isEmployee()).thenReturn(true);
		when(profile.timeSinceUserJoined()).thenReturn(3);
		when(profile.isAffiliatedUser()).thenReturn(true);
		when(context.getUserProfile()).thenReturn(profile);

		DiscountManager manager = new DiscountManager(new DollarPercentageDiscountStrategy(), context);
		assertEquals(63.0, manager.getNetPayable(90));
	}
	
	public void testDiscountManager_UserIsEmployee_UserIsLoyal_UserIsNonAffiliated_GroceryProduct_BillMoreThan100() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.Grocery);
		
		UserProfile profile = mock(UserProfile.class);
		when(profile.isEmployee()).thenReturn(true);
		when(profile.timeSinceUserJoined()).thenReturn(3);
		when(profile.isAffiliatedUser()).thenReturn(false);
		when(context.getUserProfile()).thenReturn(profile);

		DiscountManager manager = new DiscountManager(new DollarPercentageDiscountStrategy(), context);
		assertEquals(230.0, manager.getNetPayable(240));
	}
	
	
	public void testDiscountManager_UserINotEmployee_AffiliatedUser_LoyalUser_NonGroceryProduct_BillMoreThan100() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.NonGrocery);
		
		UserProfile profile = mock(UserProfile.class);
		when(profile.timeSinceUserJoined()).thenReturn(3);
		when(profile.isAffiliatedUser()).thenReturn(true);
		when(context.getUserProfile()).thenReturn(profile);

		DiscountManager manager = new DiscountManager(new DollarPercentageDiscountStrategy(), context);
		assertEquals(206.0, manager.getNetPayable(240));
	}
	
	public void testDiscountManager_UserIsEmployee_AffiliatedUser_LoyalUser_GroceryProduct_BillMoreThan100() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.Grocery);
		
		UserProfile profile = mock(UserProfile.class);
		when(profile.timeSinceUserJoined()).thenReturn(3);
		when(profile.isAffiliatedUser()).thenReturn(true);
		when(context.getUserProfile()).thenReturn(profile);

		DiscountManager manager = new DiscountManager(new DollarPercentageDiscountStrategy(), context);
		assertEquals(230.0, manager.getNetPayable(240));
	}
	
	public void testDiscountManager_AffiliatedUser_NonLoyalUser_NonGroceryProduct() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.NonGrocery);
		
		UserProfile profile = mock(UserProfile.class);
		when(profile.timeSinceUserJoined()).thenReturn(2);
		when(profile.isAffiliatedUser()).thenReturn(true);
		when(context.getUserProfile()).thenReturn(profile);

		DiscountManager manager = new DiscountManager(new DollarPercentageDiscountStrategy(), context);
		assertEquals(206.0, manager.getNetPayable(240));
	}
	
	public void testDiscountManager_NonAffiliatedUser_LoyalUser_NonGroceryProduct() {
		Context context = mock(Context.class);
		when(context.getProductType()).thenReturn(ProductType.NonGrocery);
		
		UserProfile profile = mock(UserProfile.class);
		when(profile.timeSinceUserJoined()).thenReturn(2);
		when(profile.isAffiliatedUser()).thenReturn(false);
		when(context.getUserProfile()).thenReturn(profile);

		DiscountManager manager = new DiscountManager(new DollarPercentageDiscountStrategy(), context);
		assertEquals(230.0, manager.getNetPayable(240));
	}
	
	}
